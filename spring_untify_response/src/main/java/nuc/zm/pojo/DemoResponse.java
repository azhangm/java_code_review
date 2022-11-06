package nuc.zm.pojo;

/**
 * 演示反应
 *
 * @author zm
 * @date 2022/10/24
 */
public class DemoResponse<T> {

    private Integer code;

    private String message;

    private T Data;

    public DemoResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public DemoResponse(T data) {
        code = 200;
        message = "success";
        Data = data;
    }

    private DemoResponse(ExceptionEnum e) {
        this.code = e.getCode();
                this.message = e.getMessage();
    }
//    这里加泛型是因为 有警告 看着难受
    public static  DemoResponse<String>  success() {
        return  new DemoResponse<>(null);
    }

    public static <T> DemoResponse<T>  success(T data) {
        return  new DemoResponse<>(data);
    }

//    这里加泛型是因为 有警告 看着难受
    public static DemoResponse<String> fail() {
//        根据 接口开发 文档 根据实际情况选择 10001
        return  new DemoResponse<>(10001,"failed");
    }

    public static  DemoResponse<ExceptionEnum> fail(ExceptionEnum e) {
        System.out.println("异常信息返回");
        return new DemoResponse<>(e.getCode(),e.getMessage());
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

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
