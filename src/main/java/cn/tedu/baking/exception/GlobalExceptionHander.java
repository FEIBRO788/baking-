package cn.tedu.baking.exception;

import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalExceptionHander {

    @ExceptionHandler(IllegalArgumentException.class)
    public JsonResult doHanderIllegalArgumentException(IllegalArgumentException e){
        log.warn("发生了illegalArgumentException异常",e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHanderRuntimeException(RuntimeException e){
        log.warn("发生了RuntimeException异常",e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }
    @ExceptionHandler(Throwable.class)
    public JsonResult doHanderTrowable(Throwable e){
        log.warn("发生了异常",e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED,e.getMessage());
    }

}
