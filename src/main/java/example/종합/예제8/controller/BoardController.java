package example.종합.예제8.controller;

import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController // 해당 컨트롤러는 http웹 기능 갖게 된다 <싱글톤 유사 포함>
public class BoardController {
//    private BoardController(){}
//    private static final BoardController instance = new BoardController();
//    public static BoardController getInstance(){return instance;}

    private BoardDao bd =BoardDao.getInstance();

    //게시물 등록 컨트롤러
    @PostMapping
    public boolean write(String bcontent , String bwriter){
        boolean result = bd.write(bcontent,bwriter);
        return result;
    }

    // 게시물 삭제 컨트롤러
    @DeleteMapping
    public boolean delete(int bno){
        boolean result = bd.delete(bno);
        return result;
    }

    // 게시물 수정 컨트롤러
    @PutMapping
    public boolean update(int bno , String bcontent){
        boolean result = bd.update(bno,bcontent);
        return result;
    }
    @GetMapping // 해당 메소드의 http웹 통신 기능 갖게 된다
    // 게시물 전체조회 컨트롤러  여러개 레코드조회 -> ArrayList 한개 레코드 조회 -> BoardDto
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }


}
