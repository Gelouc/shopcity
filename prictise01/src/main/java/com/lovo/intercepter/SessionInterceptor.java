package com.lovo.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.intercepter.JWTInterceptor;
import com.lovo.result.Result;
import com.lovo.result.ResultCode;
import com.lovo.result.UserValid;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

public class SessionInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if(!(handler instanceof HandlerMethod)){
//            return true;
//        }
//        HandlerMethod handlerMethod=(HandlerMethod)handler;
//        Method method=handlerMethod.getMethod();
//        if(!method.isAnnotationPresent(UserValid.class)){
//            return true;
//        }
//        HttpSession session = request.getSession();
//        if(session.getAttribute("user") == null){
//            writeValueAsString(response, Result.fail(ResultCode.USER_AUTHENTICATION_ERROR));
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 将返回的对象以流的方式响应会客户端
//     * @param response
//     * @param result
//     * @throws IOException
//     */
//    private void writeValueAsString(HttpServletResponse response,Result result) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().print(mapper.writeValueAsString(Result.fail(ResultCode.USER_NOT_LOGGED_IN)));
//    }
}
