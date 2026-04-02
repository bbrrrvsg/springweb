package springweb.member.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    // [*] 비밀키 정의
    private String secret = "12312312312414213213213123123213123213213213123"; // 개발자가 임의로 32글자 이상의 문자열 구성

    private Key secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); // SHA-256알고리즘으로 비밀키 생성

    // [1] 토큰 발급 : 특정한 자료를 이해하기 어려운 자료로 변경
    public String createToken(String mid){
        String token = Jwts.builder() // 토큰객체 생성 빌더 시작
                .claim("mid" , mid )//key 와 value 쌍으로 토큰에 저장할 값(여러개 가능)
                .setIssuedAt(new Date(System.currentTimeMillis()*1000*60*60*24))
                .signWith(secretKey , SignatureAlgorithm.HS256) // 토큰의 비밀키를 넣고
                .compact(); // 토큰 객체 생성 빌더 종료

        return token;
    }

    // [2] 토큰의 클레임(내용물) 추출

    public String getClaim(String token){
        try{
            Claims claim = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody(); // 서명확인 토큰내 클래임(내용물) 반환 / 없으면 예외 발생
            Object object = claim.get("mid");
            return (String)object;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return null;
    }
}
