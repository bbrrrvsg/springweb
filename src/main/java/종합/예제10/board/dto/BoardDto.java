package 종합.예제10.board.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;

@AllArgsConstructor@NoArgsConstructor@Data@Builder
public class BoardDto {
    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String createDate;
    private String updateDate;

    //dto-->entity // 저장
    public BoardEntity toEntity(){
        return BoardEntity
                .builder()
                // .bno(bno) createDate , updateDate 생략가능 저장하기 때문에
                .bcontent(bcontent)
                .btitle(btitle)
                .bwriter(bwriter)
                .build();
    }
}
