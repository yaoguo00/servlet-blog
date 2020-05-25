package frank.servlet;

import frank.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author guoyao
 * @create 2020/3/14
 */

//百度富文本编辑器
//可以上传图片

@WebServlet("/ueditor")
public class UeditorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取路径
        String rootPath=getClass().getClassLoader().getResource("config.json").getPath();
        //实例化类
        MyActionEnter actionEnter=new MyActionEnter(req,rootPath);
        //
        String exe=actionEnter.exec();
        //将String返回到前端
        PrintWriter pw=resp.getWriter();
        pw.println(exe);
        pw.flush();

    }
}
