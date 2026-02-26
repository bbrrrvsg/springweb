package example.prcatice.practice2.p2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/board")
public class BoardController {

    ArrayList<BoardDto>boards = new ArrayList<>();
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        boolean result = boards.add(boardDto);
        return result;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto>boardPrint(){
        ArrayList<BoardDto>list = new ArrayList<>();
        BoardDto boardDto1 = new BoardDto(1,"내용1","작성자1");
        BoardDto boardDto2 = new BoardDto(2,"내용2","작성자2");
        list.add(boardDto1); list.add(boardDto2);
        return list;

    }
    @GetMapping("/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        BoardDto boardDto = new BoardDto(1,"내용1","작성자1");
        return boardDto;
    }
    @DeleteMapping
    public boolean boardDelete(@RequestParam int bno){
        return false;
    }
    @PutMapping
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return true;
    }
}
