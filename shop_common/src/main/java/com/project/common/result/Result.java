package com.project.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result implements Serializable {
    private Integer status;
    private String message;
    private Object data;
    public Result(ResultCode resultCode, Object data){
        this.status = resultCode.status();
        this.message = resultCode.message();
        this.data = data;
    }
    public Result(ResultCode resultCode){
        this.status = resultCode.status();
        this.message = resultCode.message();
    }

    // 返回成功
    public static Result success(){
        Result resultVO = new Result(ResultCode.SUCCESS);
        return resultVO;
    }
    // 返回成功
    public static Result success(Object data){
        Result resultVO = new Result(ResultCode.SUCCESS,data);
        return resultVO;
    }
    // 返回失败
    public static Result fail(ResultCode resultCode){
        Result resultVO = new Result(resultCode);
        return resultVO;
    }
    // 返回失败
    public static Result fail(ResultCode resultCode, Object data){
        Result resultVO = new Result(resultCode,data);
        return resultVO;
    }
}
