package resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/respDemo1")
public class RespDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletContext().toString());
        System.out.println(this.getServletContext());

        System.out.println("demo1.....");
//        /**
//         * 设置状态码
//         */
//        resp.setStatus(HttpServletResponse.SC_FOUND);
//
//        /**
//         * 设置跳转路径
//         */
//        resp.setHeader("location","/login/respDemo2");


        resp.sendRedirect("/login/respDemo2");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
