package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guoyao
 * @create 2020/3/14
 */

@WebServlet("/articleDetail")
//文章详情查询页面
public class ArticleDetailServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //根据ID查询文章详情页面
        Integer id=Integer.parseInt(req.getParameter("id"));
        Article artucle= ArticleDAO.queryByArticleId(id);

        return artucle;
    }
}
