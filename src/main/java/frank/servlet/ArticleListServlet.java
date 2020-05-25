package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author guoyao
 * @create 2020/3/7
 */
@WebServlet("/articleList")

//文章列表
public class ArticleListServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析请求数据id=1
        Integer id=Integer.parseInt(req.getParameter("id"));
        //数据库查询id=1的用户，该用户发表的所有文章数据，返回给客户端

        List<Article> articles= ArticleDAO.queryByUserId(id);
        //TODO

        return articles;
    }
}
