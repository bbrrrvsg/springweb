package 종합.예제9.model.dao;

import 종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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


    //[1] 전체조회
    public List<BoardDto> findAll(){
        List<BoardDto>list = new ArrayList<>();
        try{
            String sql = "Select*from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //rs.get타입명(속성명) : 현재레코드의 속성 값 호출
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getString("bdate");

                // DTO 만들기
                BoardDto boardDto = new BoardDto(bno, bcontent, bwriter, bdate);
                // 리스트 저장
                list.add(boardDto); // 리스트에 생성한 DTO(레코드) 저장
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return list;
    }

    //[2] 게시물등록
    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board(bcontent,bwriter) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBcontent());
            ps.setString(2,boardDto.getBwriter());
            int count = ps.executeUpdate();
            if(count==1)return true;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }

    //[3] 게시물 수정
    public boolean update(BoardDto boardDto){
        try{
            String sql="update board set bcontent =? where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());

            int count = ps.executeUpdate();
            if(count==1){return true;}


        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }

    //[4] 게시물삭제
    public boolean delete(int bno){
        try{
            String sql= "delete from board where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if(count==1){return true;}
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }



}
