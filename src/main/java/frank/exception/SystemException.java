package frank.exception;

/**
 * @author guoyao
 * @create 2020/3/9
 */
//系统异常
public class SystemException extends BaseException {

    public SystemException(String code, String message) {
        super(code, message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
