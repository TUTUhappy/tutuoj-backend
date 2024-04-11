package tu.tutu.tutuojbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tu.tutu.tutuojbackend.common.BaseResponse;
import tu.tutu.tutuojbackend.common.ErrorCode;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public BaseResponse error(CommonException e){
        log.error("CommonException:"+e);

        return  new BaseResponse(e.getCode(),e.getMessage(),e.getDescription());

    }
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse error(RuntimeException e){
        log.error("RuntimeException:"+e);
        return  new BaseResponse(ErrorCode.RUN_ERROR,e.getMessage(),"运行时异常");

    }


}
