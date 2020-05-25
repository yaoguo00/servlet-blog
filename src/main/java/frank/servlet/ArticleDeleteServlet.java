package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guoyao
 * @create 2020/3/14
 */

//文章删除
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //可以删除多个文章
        String [] idsStr=req.getParameter("ids").split(",");
        int [] ids=new int[idsStr.length];
        for(int i=0;i<idsStr.length;i++){
            ids[i]=Integer.parseInt(idsStr[i]);
        }
        if(!ArticleDAO.delete(ids)){
            throw new BusinessException("adelete001","文章删除数据=0");
        }
        return null;
    }
}
