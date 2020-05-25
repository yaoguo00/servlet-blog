package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exception.BusinessException;
import frank.model.Article;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guoyao
 * @create 2020/3/14
 */

//文章更新
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //进行反序列化成一个对象
        Article article= JSONUtil.deserialize(req.getInputStream(),Article.class);

        if(!ArticleDAO.update(article)){
            throw new BusinessException("aupdate001","修改文章操作执行数量=0");
        }
        return null;
    }
}
