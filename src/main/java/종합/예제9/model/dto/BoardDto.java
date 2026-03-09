package 종합.예제9.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // setter + getter + toString + RequiredArgsConstructor( final멤버변수 생성자 )
public class BoardDto {
    // 멤버변수 : 데이터베이스의 속성명 과 일치 , +기능에 따라 추가
    private Integer bno; // int -> Integer 사용하여 null값 대응
    private String bcontent;
    private String bwriter;
    private String bdate;

}
