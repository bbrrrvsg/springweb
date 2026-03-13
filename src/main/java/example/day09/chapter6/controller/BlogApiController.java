package example.day09.chapter6.controller;

import example.day09.chapter6.domain.Article;
import example.day09.chapter6.dto.AddArticleRequest;
import example.day09.chapter6.dto.ArticleResponse;
import example.day09.chapter6.dto.UpdateArticleRequest;
import example.day09.chapter6.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor // final 생성자
public class BlogApiController {

    private final BlogService blogService; // final 쓰면 @RequiredArgsConstructor필수


    // 블로그 글추가
    @PostMapping("/api/articles")
    //public Article addArticle(@RequestBody AddArticleRequest request ){
    public ResponseEntity<Article>addArticle(@RequestBody AddArticleRequest request){
    // ResponseEntity< 반환타입 > : HTTP 응답 객체 수정/커스텀 가능하다. 응답정보 수정 , 응답객체 포장 느낌
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(201).body(savedArticle);
    }

    // 블로그 글 목록 조회
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>>findAllArticles(){
        List<Article>list = blogService.findAll();

        List<ArticleResponse>articleResponses=new ArrayList<>();

        list.forEach((entity)->{
            ArticleResponse articleResponse= new ArticleResponse(entity);
            articleResponses.add(articleResponse);
        });
        return ResponseEntity.status(200).body(articleResponses);
    }

    // 블로그 글 조회
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse>findArticle(@PathVariable("id") Long id){
          Article article = blogService.findById(id);

          ArticleResponse articleResponse = new ArticleResponse(article);

          return ResponseEntity.status(200).body(articleResponse);
    }

    // 블로그 글 삭제
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void>deleteArticle(@PathVariable("id") Long id){
        blogService.delete(id);
        return ResponseEntity.status(200).build(); // 반환값이 없다는 뜻
    }

    // 블로그 글 수정
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article>updateArticles(@PathVariable("id") Long id, @RequestBody UpdateArticleRequest request){
        Article article = blogService.update(id,request);

        return ResponseEntity.status(200).body(article);
    }

}
