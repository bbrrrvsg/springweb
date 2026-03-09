package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.dto.BoardDto;

@AllArgsConstructor@NoArgsConstructor@Data@Builder
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(nullable = false, length = 255)
    private String btitle;

    @Column(columnDefinition = "Longtext not null") // 직접 sql로 설정
    private String bcontent;

    @Column(length = 30 , nullable = false)
    private String bwriter;
    // baseTime 으로 상속 생성/수정날짜

    //entity --> dto // 이동
    public BoardDto toDto(){
        return BoardDto
                .builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
