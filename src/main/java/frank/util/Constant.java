package frank.util;

/**
 * @author guoyao
 * @create 2020/3/9
 */

//常量状态码
public interface Constant {

    //数据库错误码
    String DB_ERROR_CODE="500A";

    //json序列化错误码
    String JSON_ERROR_CODE="500B";

    //查询用户错误错误码
    String QUERY_USER_ERROR_CODE="500xx1";

    //用户不存在错误码
    String USER_NULL_ERROR_CODE="500xx2";

    //插入文章出错
    String INSERT_ARTICLE_ERROR_CODE="500yy1";

}
