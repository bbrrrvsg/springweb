package example.day02.Controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// @Component // 빈 등록
// @Controller +HTTP 통신기능 = 사용처 : View(화면)반환
@RestController // + ResponseBody 포함  사용처 : 값(json) 반환
@RequestMapping("/day02")//@RequestMapping("/공통url") // 해당 컨트롤러내 메소드들이 사용하는 공통url 정의한다.

public class RestController3 {

    //1. 클래스가 @RestController 이므로 @ResponseBody 생략해도 된다.
    @GetMapping("/task6") // * 클래스가 @RequestMapping의 공통 url을 가지므로 localhost:8080/day02/~
    public String method1(){
        return "서버에게 받은 메세지";
    }

    //2.
    @GetMapping("/task7")  // 쿼리스트링이한? URL(웹주소) 뒤로 ? 작성후 매개변수명=값 & 매개변수명=값
    public int method2(@RequestParam String name , @RequestParam int age ){ // 쿼리스트링매개변수==메소드매개변수
        //@RequestParam 이한? URL(웹주소) 안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 / *생략가능*
        System.out.println("RestController3.method2"); // soutm 메소드명 출력
        System.out.println("name = " + name + ", age = " + age); // soutp 매개변수 출력
        return 3;
    }

    //3.
    @GetMapping("/task8") // 만약에 쿼리스트링의 매개변수와 자바의 매개변수명이 다르면 @RequestParam(name="쿼리스트링변수명")
    public int method3(@RequestParam(required = false) String name , @RequestParam(name="age") int 나이){
        // 만약에 쿼리스트링의 매개변수명을 필수로 하지 않을경우 @RequestParam(required = false) , 기본값은 true
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 3;
    }

    //4.
    @DeleteMapping("/task9") // GET/DELETE 메소드는 구조와 사용법이 동일하다.
    public int method4(String name , @RequestParam(defaultValue = "19") int age){
        // 만약에 @RequestParam 생략해도 매개변수 매핑(연결) 가능하다
        // 만약에 쿼리스트링에 존재하지 않을떄 기본값으로 설정하기 , @RequestParam(defaultValue = "초기값")
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;
    }

    //5.
    @DeleteMapping("/task10") // 여러개 매개변수를 하나의 Map타입으로 받을수 있다.
    public int method5(@RequestParam Map<String,Object>map){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map);//map = {name=유재석, age=10}
        return 10;

    }

    //6.
    @PostMapping("/task11")
    public int method6(@ModelAttribute ExamDto examDto){
        System.out.println("examDto = " + examDto);
        System.out.println("RestController3.method6");
        return 11;
    }
    // 즉] URL?매개변수=값 방식인 쿼리스트링은 URL 상 매개변수 노출이 된다
    // GET/DELETE -> 쿼리스트링 -> @ModelAttribute/@RequestParam
    // POST/PUT -> +BODY본문 -> @ResquestBody
    //즉] URL상의 매개변수 노출을 가리기 위한 BODY(본문) 사용하자
    //      개인정보/패스워드/민감한 정보들은 POST/PUT BODY(본문) 사용하자
    //예시] 편지의 편지봉튜 = 쿼리스트링 , 편지의 내용물(편지지) = BODY

    //7.
    @PostMapping("/task12")
    //Body : {"name":"유재석" , "age":"20"}
    //HTML --> js --> java(controller -> dao)
    public int method7(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method7");
        System.out.println("examDto = " + examDto);
        return 12;
    }

    //8.
    @PutMapping("/task13")
    public int method8(@RequestBody Map<String,Object>map){
        System.out.println("RestController3.method8");
        System.out.println("map = " + map);
        return 13;
    }

}
