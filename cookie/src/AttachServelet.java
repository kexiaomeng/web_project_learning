import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/attach")
public class AttachServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String fileName = req.getParameter("filename");
        String mime = context.getMimeType(fileName); // 获取文件的mime类型

        resp.setContentType(mime);
        String realPath = context.getRealPath("/img/"+fileName);
        System.out.println(realPath);
        resp.setHeader("content-disposition","attachment;filename=" + fileName); // 附件形式打开


        FileInputStream inputStream = new FileInputStream(realPath);

        byte[] bytes = new byte[8*1024];
        int len = 0;
        while((len = inputStream.read(bytes)) != -1) {
            resp.getOutputStream().write(bytes,0,len);
        }
        inputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
