package 종합.예제10.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.service.BoardService;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 등록
    @PostMapping("/board")
    public boolean 등록(@RequestBody BoardDto boardDto){
        boolean result = boardService.등록(boardDto);
        return result;
    }

    //조회
    @GetMapping("/board")
    public List<BoardDto> 조회(){
        List<BoardDto>list=boardService.조회();
        return list;
    }

    //개별조회
    @GetMapping("/board/one")
    public BoardDto 개별조회(@RequestParam int bno){
        BoardDto boardDto = boardService.개별조회(bno);
        return boardDto;
    }

    //수정
    @PutMapping("/board")
    public boolean 수정(@RequestBody BoardDto boardDto){
        boolean result = boardService.수정(boardDto);
        return result;

    }
    //삭제
    @DeleteMapping("/board")
    public boolean 삭제(@RequestParam int bno){
        boolean result = boardService.삭제(bno);
        return result;

    }
    //
}
