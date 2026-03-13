package example.day09.chapter6.dto;

import example.day09.chapter6.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class AddArticleRequest { // dto 역할
    private String title;
    private String content;

    public Article toEntity(){
        return Article
                .builder()
                .title(title)
                .content(content)
                .build();
    }
}
