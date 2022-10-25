package nuc.zm.pojo;

/**
 * 异常
 *
 * @author zm
 * @date 2022/10/24
 */
public enum ExceptionEnum{

    DEMO_FAIL(10001,"运行失败");


    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
