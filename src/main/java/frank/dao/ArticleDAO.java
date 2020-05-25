package frank.dao;

import frank.exception.SystemException;
import frank.model.Article;
import frank.util.Constant;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guoyao
 * @create 2020/3/9
 */
public class ArticleDAO {

    //文件插入操作
    public static boolean insert(Article article){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection= DBUtil.getConnection();
            String sql="insert into article(title,content,user_id,create_time)" +
                    " values (?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getUserId());
            ps.setTimestamp(4,new Timestamp(new Date().getTime()));
            int num=ps.executeUpdate();
            return num>=1;


        }catch (Exception e){
            throw new SystemException(Constant.INSERT_ARTICLE_ERROR_CODE,"插入文章出错",e);
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    //查询文件列表操作
    public static List<Article> queryByUserId(Integer id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Article> articles=new ArrayList<>();
        try{
            connection= DBUtil.getConnection();
            String sql="select id,title,content,user_id,create_time" +
                    " from article where user_id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            //处理结果集
            while(rs.next()){
                Article article=new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        rs.getTimestamp("create_time").getTime()));
                articles.add(article);
            }

            return articles;
        }catch (Exception e){
            throw new SystemException("aquery001","查询文章列表出错",e);
        }finally {
            DBUtil.close(connection,ps,rs);
        }

    }

    //通过文章id查询文章详情
    public static Article queryByArticleId(Integer id) {

        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            connection= DBUtil.getConnection();
            String sql="select id,title,content,user_id,create_time" +
                    " from article where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            //处理结果集
            Article article=new Article();
            while(rs.next()){

                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        rs.getTimestamp("create_time").getTime()));
            }
            return article;

        }catch (Exception e){
            throw new SystemException("aquery002","查询文章详情出错",e);
        }finally {
            DBUtil.close(connection,ps,rs);
        }
    }

    //修改文章操作
    public static boolean update(Article article) {
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection= DBUtil.getConnection();
            String sql="update article set title=?,content=?" +
                    " where id=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getId());
            int num=ps.executeUpdate();
            return num>=1;

        }catch (Exception e){
            throw new SystemException("aupdate002","修改文章出错",e);
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    //删除文章操作，根据多个文章ID进行删除
    public static boolean delete(int[] ids) {
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection= DBUtil.getConnection();
            String sql="delete from article" +
                    " where id in(";
            for(int i=0;i<ids.length;i++){
                if(i==0){
                    sql+="?";
                }
                else{
                    sql+=", ?";
                }
            }
            sql+=")";
            ps=connection.prepareStatement(sql);
            for(int i=0;i<ids.length;i++){
                ps.setInt(i+1,ids[i]);
            }
            int num=ps.executeUpdate();
            return num>=1;

        }catch (Exception e){
            throw new SystemException("adelete002","删除文章出错",e);
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }
}
