package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import frank.exception.SystemException;
import frank.model.Result;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author guoyao
 * @create 2020/3/7
 */
public class JSONUtil {

    //序列化操作
    public static final String DATE_PATTERN="yyyy-MM-dd HH:mm:ss";
    public   static String serialize(Object obj){
       ObjectMapper mapper=new ObjectMapper();
       //设置日期格式类
       mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON序列化失败"+obj,e);
        }
    }

    //反序列化操作,将字符串转化为一个泛型的类
    public static <T> T deserialize(String json,Class<T> clazz){
        ObjectMapper mapper=new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON字符串反序列化失败",e);
        }
    }

    //反序列化操作，httpRequst输入流进行读取
    public static <T> T deserialize(InputStream is, Class<T> clazz){
        ObjectMapper mapper=new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(is,clazz);
        } catch (IOException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON文件反序列化失败",e);
        }
    }

    public static void main(String[] args) {
        Result result=new Result();
        result.setCode("xx301");
        result.setMessage("发表文章出错");
        result.setData("文章数据");
        //序列化
        //System.out.println(serialize(result));
        //反序列化
       String json=serialize(result);
        System.out.println(json);
        Result r2=deserialize(json,Result.class);
        System.out.println(r2);
    }
}
