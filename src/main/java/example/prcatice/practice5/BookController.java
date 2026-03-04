package example.prcatice.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //등록
    @PostMapping("/practice/practice5")
    public boolean add(@RequestBody BookDto bookDto){
        boolean result = bookService.add(bookDto);
        return result;
    }

    //조회
    @GetMapping("/practice/practice5")
    public List<BookDto>bread(){
        List<BookDto>result = bookService.bread();
        return result;
    }

    //수정
    @PutMapping("/practice/practice5")
    public boolean bupdate(@RequestBody BookDto bookDto){
        boolean result = bookService.bupdate(bookDto);
        return result;
    }

    //삭제
    @DeleteMapping("/practice/practice5")
    public boolean bdelete(@RequestParam int bno){
        boolean result = bookService.bdelete(bno);
        return result;
    }

}
