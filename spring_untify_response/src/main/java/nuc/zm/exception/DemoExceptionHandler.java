package nuc.zm.exception;

import nuc.zm.pojo.DemoResponse;
import nuc.zm.pojo.ExceptionEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public DemoResponse<ExceptionEnum> demoHandler() {
        return   DemoResponse.fail(ExceptionEnum.DEMO_FAIL);
    }

    @ExceptionHandler(DemoException.class)
    public DemoResponse<DemoException> demoResponse(DemoException e) {
        return new DemoResponse<>(e.getCode(),e.getMessage());
    }
}
