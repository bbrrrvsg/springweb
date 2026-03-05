package example.day06;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GoodsDto {
    private Integer gno;
    private String gname;
    private Integer gprice;
    private String gdesc;
    // *baseTime
    private String createdate;
    private String updatedate;

    //DTO --> ENTITY 변환 함수
    public GoodsEntity toEntity(){
        return GoodsEntity
                .builder()
                .gno(this.gno) // this 해당메소드를 호출한 객체 생략가능
                .gname(gname)
                .gprice(gprice)
                .gdesc(gdesc)
                .build();
    }
}
