package example.종합.예제8.model.dao;

import example.종합.예제8.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){connect();}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){return instance;}

    // 데이터베이스 연동

    //1. 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
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

    // [1] 게시물 등록 dao

    public boolean write(String bcontent, String bwriter){
        try {
            //1) sql 작성 ,   저장-> C -> INSERT  , ? 와일드 카디 기호로 변수값이 들어갈 자리 뜻한다.
            String sql = "insert into board(bcontent,bwriter) values(?,?)";

            //2) 연동된(conn) 인터페이스에 내가 작성한 sql 기재한다. 반환 preparedStatement 준비된 *
            PreparedStatement ps =conn.prepareStatement(sql);

            //3) sql이 기재된(ps) 인터페이스에 sql에 매개변수 대입 // ps.set타입명(?순서번호 , 값);
            ps.setString(1,bcontent); // String 타입으로 sql내 1번 ? 에 bcontent 값 대입한다.
            ps.setString(2,bwriter); // String 타입으로 sql내 2번 ? 에 bwriter 값 대입한다.

            //4) 매개변수 까지 대입하여 준비가 끝났으면 sql 실행 ,ps.executeUpdate(); 반환값은 반영된 레코드수
            int count = ps.executeUpdate();

            //5) sql 실행 후 반영된 레코드수에 따른 결과 제어
            if(count ==1){return true;} // 등록한 레코드수가 1이면 등록 성공
            else {return false;} // 아니면 실패

        }catch (SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e );
        }
        return false; // 실패
    } // m end



    //[4] 게시물 삭제 dao
    public boolean delete(int bno) {

        try {
            //1] sql 작성한다. , ?는 매개변수가 들어갈 자리
            String sql = "delete from board where bno = ?";

            //2] 연동된 conn 인터페이스에 sql 기재한다 .
            PreparedStatement ps = conn.prepareStatement(sql);

            //3] ?와일드카드에 매개변수 대입 , ps.set타입명(?순서번호,값);
            ps.setInt(1,bno); // 1번 와일드카드에 bno
            //4] 실행  , 실행후 반영된 레코드수
            int count = ps.executeUpdate();

            if (count ==1){return true;}
            else {return false;}

        }catch (SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e );
        }
        return false;
    }// m end


    //게시물 수정 dao
    public boolean update(int bno , String bcontent){
        try{
            String sql = "update board set bcontent = ? where bno =?";//1. sql 작성

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, bcontent);
            ps.setInt(2, bno);

            int count = ps.executeUpdate();

            if(count==1){return true;}
            else {return false;}


        }catch (SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e );
        }
        return false;
    }// m end

    // 게시물 전체조회 dao

    public ArrayList<BoardDto>findAll(){
        ArrayList<BoardDto>boards = new ArrayList<>(); // 조회결과 레코드들을 저장할 리스트 선언
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            // ? 매개변수 없으므로 생략 ps.setxxx()
            // ps.executeUpdate();-> insert,delete,update         ps.executeQuery(); -> select
            // ResultSet : select 결과물을 제어하느 인터페이스 .
            // rs.next() : 조회결과에서 다음 레코드 1번 이동 , 만약에 레코드가 10개이면 next10번
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //rs.get타입명(속성명) : 현재레코드의 속성 값 호출
                int bno = rs.getInt("bno");  String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter"); String bdate = rs.getString("bdate");

                // DTO 만들기
                BoardDto boardDto = new BoardDto(bno,bcontent,bwriter,bdate);
                // 리스트 저장
                boards.add(boardDto); // 리스트에 생성한 DTO(레코드) 저장
            }// w end
        }catch (SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e );
        }
        return boards;
    }// m end




}// class end
