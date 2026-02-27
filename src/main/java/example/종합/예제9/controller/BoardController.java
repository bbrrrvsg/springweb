package example.종합.예제9.controller;

import example.종합.예제9.model.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController // 빈동록 + HTTP기능 + HTTP응답객체
public class BoardController {

    @Autowired // 의존성 주입 : 등록된 빈(객체) 가져오기
    private BoardDao boardDao;

}
