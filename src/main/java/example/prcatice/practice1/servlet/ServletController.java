package example.prcatice.practice1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;

import java.io.IOException;

@WebServlet("/practice1/servlet")
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 보내온 값 가져오기 = 요청한 정보가 들어있는 매개변수 : HttpServletRequest req
        String data=req.getParameter("data"); // http 는 텍스트 전송이 기본값이다
        int num = Integer.parseInt(data); // 타입변환
        // 2. 계산된 값을 반환 = 요청한 클라이언트에게 계산 결과를 응답 HttpServletResponse resp
        resp.getWriter().println(num+2);
        System.out.println("(num+2) = " + (num+2));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=req.getParameter("data");
        int num = Integer.parseInt(data);
        resp.getWriter().println(num*2);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=req.getParameter("data");
        int num = Integer.parseInt(data);
        resp.getWriter().println(num/2);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=req.getParameter("data");
        int num = Integer.parseInt(data);
        resp.getWriter().println(num%2);
    }
}
