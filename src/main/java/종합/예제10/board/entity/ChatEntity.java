package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.dto.ChatDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity@Table(name = "chat")
public class ChatEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;

    @Column(name = "cwriter")
    private String cwriter;

    @Column(columnDefinition = "longtext not null")
    private String comment;

    @Column
    private Integer bno;
    //entity --> dto // 이동
    public ChatDto toDto(){
        return ChatDto
                .builder()
                .cno(cno)
                .comment(comment)
                .cwriter(cwriter)
                .bno(bno)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
