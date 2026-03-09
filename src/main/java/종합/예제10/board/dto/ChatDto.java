package 종합.예제10.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.ChatEntity;

import java.time.LocalDateTime;

@AllArgsConstructor@NoArgsConstructor@Data@Builder
public class ChatDto {

    private Integer cno;


    private String cwriter;

    private String comment;

    private Integer bno;

    private String createDate;
    private String updateDate;


    public ChatEntity toEntity(){

        return ChatEntity
                .builder()
                .bno(bno)
                .comment(comment)
                .cwriter(cwriter)
                .build();

    }
}
