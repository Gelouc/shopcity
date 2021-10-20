package com.lovo.result;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authz.UnauthorizedException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@NoArgsConstructor
@Data
public class GlobalHandleException extends Throwable {
    private ResultCode resultCode;

    public GlobalHandleException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlemethodArgumentNotValid(MethodArgumentNotValidException exception) {
        Result resultVO = Result.fail(ResultCode.PARAM_IS_INVALID);
        return resultVO;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolation(ConstraintViolationException exception) {
        Result resultVO = Result.fail(ResultCode.PARAM_IS_INVALID);
        return resultVO;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handleUnauthorized(UnauthorizedException exception) {
        Result resultVO = Result.fail(ResultCode.USER_AUTHORIZATION_ERROR);
        return resultVO;
    }

}
