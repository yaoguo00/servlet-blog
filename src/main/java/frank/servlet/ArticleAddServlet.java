package frank.servlet;

import frank.dao.ArticleDAO;
import frank.dao.UserDAO;
import frank.exception.BusinessException;
import frank.model.Article;
import frank.model.User;
import frank.util.Constant;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author guoyao
 * @create 2020/3/8
 */
//获取路径，把创建的servlet配置到tomcat容器中，让其加载进去
@WebServlet("/articleAdd")

//增加文章
public class ArticleAddServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从输入流中获取json技术
        InputStream is= req.getInputStream();
        Article article= JSONUtil.deserialize(is,Article.class);
        //根据传入数据的userAccout
        User user= UserDAO.queryByName(article.getUserAccout());
        if(user==null){  //自己插入用户数据到数据库，name=stu
            throw new BusinessException(Constant.USER_NULL_ERROR_CODE,"该用户不存在，无法发表文章");
        }
        //如果用户存在，直接插入文章数据
        article.setUserId(user.getId());
        if(!ArticleDAO.insert(article)){
            throw new BusinessException(Constant.INSERT_ARTICLE_ERROR_CODE,"文章插入0条数据");
        }
       return null;
    }
}
