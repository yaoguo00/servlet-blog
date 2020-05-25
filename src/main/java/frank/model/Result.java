package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author guoyao
 * @create 2020/3/7
 */

//使用lombok简化代码
@Getter
@Setter
@ToString


//返回给前端的数据，涉及到前端数据解析的知识点，返回json数据格式
public class Result {

    //是否请求成功
    private boolean success;

    //错误码
    private String code;

    //错误信息
    private String message;

    //返回数据
    private Object data;


}
