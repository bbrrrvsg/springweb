package springweb.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JwtService;
import springweb.member.service.MemberService;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/member2")
@CrossOrigin(origins = "http://localhost:5173" , exposedHeaders = "Authorization")
public class MemberController2 {

    private final MemberService memberService;
    private final JwtService jwtService;

    // [1] 회원가입 == 세션방식 과 동일 하므로 생략


    // [2] 로그인 post = select = find
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto ){
        // 1] 입력받은 아이디/비밀번호를 서비스에게 보낸다.
        boolean result = memberService.login( loginDto );
        // 2] 만약에 로그인 성공이면
        if( result ) {
            String token = jwtService.createToken(loginDto.getMid());
            return ResponseEntity.ok()
                    .header("Authorization","Bearer "+token) // HTTP 통신의 부가 정보를 담는 구역 (주로 인증정보 포함)
            // 클라이언트에게 헤더에 발급받은 토큰을 반환한다. Barer token (띄어쓰기 주의)
                    .body(true); // 성공의미
        }
        // 3] 아니면 실패
        return ResponseEntity.ok( result );
    }


    // [3] 로그아웃 = 세션방식 ---> 토큰방식 변경
    // 서버가 token 저장하고 있지 않기 떄문에 통신이 필요없다
    // 즉] 클라이언트 측에서 token 제거하면 된다




    // [4] 마이페이지 = 세션방식 ----> 토큰방식 변경
    @GetMapping("/my/info")
    public ResponseEntity<?>myInfo(@RequestHeader("Authorization") String token){
//        @RequestHeader : HTTP 요청의 header 정보 매핑
        // 1] RequestHeade("Authorization") String token 매개변수로 받는다
        // 2] 만약에 헤더가 없거나 토큰이 없으면 비로그인
        if (token == null || !token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        // 3] 토큰 추출
        token = token.replace("Bearer " , ""); // Bearer 없애기 a를b로 치환

        // 4] 토큰에서 값(클레임) 추출
        String mid = jwtService.getClaim(token);
        if(mid == null)return ResponseEntity.ok(false);
        // 5] 토큰에서 꺼낸 값(mid)으로 회원 정보 요청하기
        return ResponseEntity.ok(memberService.myinfo(mid));
    }



}
