package example.prcatice.practice5;

import com.sun.source.tree.LambdaExpressionTree;
import example.day05.mvc.ExamEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //등록
    public boolean add(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBno(bookDto.getBno());
        bookEntity.setBname(bookDto.getBname());
        bookEntity.setBwriter(bookDto.getBwriter());
        bookEntity.setBpublisher(bookDto.getBpublisher());

        BookEntity bookSaveEntity = bookRepository.save(bookEntity);
        if(bookSaveEntity.getBno()>=1){
            return true;
        }
        return false;
    }

    //조회
    public List<BookDto> bread(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDto>bookDtos = new ArrayList<>();
        bookEntities.forEach( bookEntity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBno(bookEntity.getBno());
            bookDto.setBname(bookEntity.getBname());
            bookDto.setBwriter(bookEntity.getBwriter());
            bookDto.setBpublisher(bookEntity.getBpublisher());
            bookDtos.add(bookDto);
        });

        return bookDtos;

    }

    //수정
    public boolean bupdate(BookDto bookDto){
        Optional<BookEntity>optional=bookRepository.findById(bookDto.getBno());
        if(optional.isPresent()){
            BookEntity bookEntity = optional.get();
            bookEntity.setBname(bookDto.getBname());
            bookEntity.setBwriter(bookDto.getBwriter());
            bookEntity.setBpublisher(bookDto.getBpublisher());
            return true;
        }
        return false;
    }

    //삭제
    public boolean bdelete(int bno){
        bookRepository.deleteById(bno);
        return true;
    }
}
