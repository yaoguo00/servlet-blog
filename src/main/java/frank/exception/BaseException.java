package frank.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author guoyao
 * @create 2020/3/9
 */

@Getter
@Setter
//父类的异常，继承运行时异常
public class BaseException extends RuntimeException{

    //错误码
    private String code;

    //发生错误返回前端的消息
    private String message;

    public BaseException(String code,String message) {
        super(message);
        this.code=code;
        this.message=message;
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
        this.message=message;
    }
}
