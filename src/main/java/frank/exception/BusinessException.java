package frank.exception;

/**
 * @author guoyao
 * @create 2020/3/9
 */
//业务方面异常（新增文章用户不存在等）
public class BusinessException extends BaseException {
    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
