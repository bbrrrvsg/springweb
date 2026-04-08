package springweb.board.entity;


import jakarta.persistence.*;
import lombok.*;
import springweb.board.dto.BoardDto;
import springweb.member.entity.MemberEntity;
import springweb.member.entity.baseTime;

@Entity @Table(name = "board")
@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class BoardEntity extends baseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(nullable = false, length = 255)
    private String btitle;
    @Column(nullable = false,columnDefinition = "longtext")
    private String bcontent;
    @Column(nullable = true , columnDefinition = "longtext") // 주로 첨부파일은 파일자체를 저장하는게 아니라 파일의위치(서버내경로) 저장
    private String bfile; // 게시물당 첨부파일 여러개이면 엔티티 분리 해야함

    // 단방향 : 한명의 회원이 여러개 게시물 작성 1:N 관계
    @ManyToOne
    @JoinColumn(name = "mno")
    @ToString.Exclude
    private MemberEntity memberEntity;

    // toDto
    public BoardDto toDto(){
        return BoardDto
                .builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                .mno(memberEntity.getMno())
                .mname(memberEntity.getMname())
                .createDate(getCreate_date().toString())
                .build();
    }
}
