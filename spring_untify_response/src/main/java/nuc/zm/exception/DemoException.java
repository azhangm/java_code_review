package nuc.zm.exception;

import nuc.zm.pojo.ExceptionEnum;

/**
 * 演示例外
 *
 * @author zm
 * @date 2022/10/25
 */
public class DemoException extends RuntimeException {

    private Integer code;
    private String  message;

    public DemoException(ExceptionEnum exceptionEnum) {
        code = exceptionEnum.getCode();
        message = exceptionEnum.getMessage();
    }

    public DemoException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
