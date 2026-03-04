package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    //조회
    @GetMapping("/day05/exam")
    public List<ExamDto> 전체조회(){
        List<ExamDto>result = examService.전체조회();
        return result;
    }
    //쓰기
    // body : {"ename" : "홍길동" }
    @PostMapping("/day05/exam")
    public boolean 저장(@RequestBody ExamDto examDto){
        boolean result = examService.저장(examDto);
        return result;
    }
    //삭제
    @DeleteMapping("/day05/exam")
    public boolean 삭제(@RequestParam int eno){
        boolean result = examService.삭제(eno);
        return result;
    }
    //수정
    @PutMapping("/day05/exam")
    public boolean 수정(@RequestBody ExamDto examDto){
        boolean result = examService.수정(examDto);
        return result;
    }

}
