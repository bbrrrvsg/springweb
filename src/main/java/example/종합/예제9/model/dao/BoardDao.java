package example.종합.예제9.model.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

@Component // 빈 등록
public class BoardDao {
    public BoardDao(){  connect(); }
    // 데이터베이스 연동

    //1. 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root";
    private String password = "1234";


    //2. 연동 인터페이스 선언
    private Connection conn;

    //3. 연동 함수 선언 , dao 생성자에서 함수 실행 (dao 싱글톤이 생성되면서 db연동 실행)
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 라이브러리 객체 메모리할당 /불러오기
            conn = DriverManager.getConnection(url,user,password); // mysql구현체로 db연동후 연동 인터페이스에 반환
            System.out.println("데이터베이스 연동 성공");
        }catch (Exception e){
            System.out.println("DB연동 실패");
            e.printStackTrace();
        }
    } // m end
}
