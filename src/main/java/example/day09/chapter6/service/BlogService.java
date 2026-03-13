package example.day09.chapter6.service;

import example.day09.chapter6.domain.Article;
import example.day09.chapter6.dto.AddArticleRequest;
import example.day09.chapter6.dto.UpdateArticleRequest;
import example.day09.chapter6.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글추가
    public Article save(AddArticleRequest request){
        return  blogRepository.save(request.toEntity());
    }

    // 블로그 글 목록 조회
    public List<Article>findAll(){
        return blogRepository.findAll();
    }

    // 블로그 글 조회
    public Article findById(Long id){
        Optional<Article>optionalArticle= blogRepository.findById(id);
        if (optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
    }

    // 블로그 글 삭제
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정
    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Optional<Article>optionalArticle = blogRepository.findById(id);
        if (optionalArticle.isPresent()){
            Article article = optionalArticle.get();
            article.update(request.getTitle(), request.getContent());
            return article;
        }
        return null;
    }
}
