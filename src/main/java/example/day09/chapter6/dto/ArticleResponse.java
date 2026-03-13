package example.day09.chapter6.dto;

import example.day09.chapter6.domain.Article;
import lombok.Getter;

@Getter // 응답할때 사용 되는 dto 역할
public class ArticleResponse {
    private final String title;
    private final String content;


    public ArticleResponse(Article article){
        this.title=article.getTitle();
        this.content=article.getContent();
    }
}
