package com.lovo.intercepter;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.bean.UserBean;
import com.lovo.mapper.IUserMapper;
import com.lovo.result.GlobalHandleException;
import com.lovo.result.Result;
import com.lovo.result.ResultCode;
import com.lovo.result.UserValid;
import com.lovo.service.IUserService;
import com.lovo.util.JWTUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class JWTInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private IUserMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //检查是否有UserValid注释，没有则跳过认证
        if (!method.isAnnotationPresent(UserValid.class)) {
            return true;
        }
        if(token == null){
            writeValueAsString(response,Result.fail(ResultCode.USER_NOT_LOGGED_IN));
            return false;
        }
        String userId;
        try {
            userId = JWTUtil.getAudience(token);
        } catch (GlobalHandleException j) {
            writeValueAsString(response, Result.fail(ResultCode.USER_NOT_LOGGED_IN));
            return false;
        }
        UserBean userInfoBean = mapper.selectById(Long.parseLong(userId));
        if(userInfoBean == null){
            writeValueAsString(response,Result.fail(ResultCode.USER_NOT_EXIST));
            return false;
        }
        // 验证 token
        try {
            JWTUtil.verifyToken(token,userInfoBean.getPwd());
        } catch (TokenExpiredException e) {
            writeValueAsString(response,Result.fail(ResultCode.TOKEN_EXPIRED));
            return false;
        }catch (Exception e) {
            writeValueAsString(response,Result.fail(ResultCode.USER_AUTHENTICATION_ERROR));
            return false;
        }
        request.setAttribute("user",userInfoBean);
        return true;
    }
    private void writeValueAsString(HttpServletResponse response, Result result) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(mapper.writeValueAsString(result));


    }

}
