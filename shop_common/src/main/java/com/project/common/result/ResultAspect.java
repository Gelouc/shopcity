package com.project.common.result;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

//import javax.persistence.OptimisticLockException;

@Aspect
@Component
@Slf4j
public class ResultAspect {
    @AfterThrowing(value = "execution(* com.project.*.service..*(..))",throwing = "e")
    public void exceptionHandler(Throwable e) throws Throwable {
        e.printStackTrace();
        log.error(e.getMessage() +" : " + e);
        ResultCode resultCode = null;
        if(e instanceof EmptyResultDataAccessException){
            resultCode = ResultCode.SERVER_EMPTY_RESULT_DATA_ACCESS_ERROR;
        }else if(e instanceof GlobalHandleException){
            resultCode = ((GlobalHandleException) e).getResultCode();
        }else{
            resultCode = ResultCode.SERVER_INNER_ERROR;
        }
        throw new GlobalHandleException(resultCode);

    }

    @Around("execution(* com.project.*.controller..*(..))")
    public Object generateResult(ProceedingJoinPoint joinPoint) throws Throwable {

        Object obj = null;
        Class clazz = null;
        Method targetMethod = null;
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature)signature;
            targetMethod = methodSignature.getMethod();
            clazz = joinPoint.getTarget().getClass();

            obj = joinPoint.proceed(joinPoint.getArgs());
            //判断类上是否加了注解
            if (isAnnotationPresent(clazz,targetMethod)) {
                obj = Result.success(obj);
            }
        }
//        catch(IncorrectCredentialsException e){
//            e.printStackTrace();
//            log.error(e.getMessage() + e);
//            if (isAnnotationPresent(clazz,targetMethod)){
//                obj = Result.fail(ResultCode.USER_PASS_ERROR);
//            }else{
//                throw e;
//            }
//        } catch(UnknownAccountException e){
//            e.printStackTrace();
//            log.error(e.getMessage() + e);
//            if (isAnnotationPresent(clazz,targetMethod)){
//                obj = Result.fail(ResultCode.USER_NOT_EXIST);
//            }else{
//                throw e;
//            }
//        } catch(AuthenticationException e){
//            e.printStackTrace();
//            log.error(e.getMessage() + e);
//            if (isAnnotationPresent(clazz,targetMethod)){
//                obj = Result.fail(ResultCode.USER_AUTHENTICATION_ERROR);
//            }else{
//                throw e;
//            }
//        }catch(AuthorizationException e){
//            e.printStackTrace();
//            log.error(e.getMessage() + e);
//            if (isAnnotationPresent(clazz,targetMethod)){
//                obj = Result.fail(ResultCode.USER_AUTHORIZATION_ERROR);
//            }else{
//                throw e;
//            }
//        }
        catch(UndeclaredThrowableException e){
            e.printStackTrace();
            log.error(e.getMessage() + e);
            if (clazz.isAnnotationPresent(ResponseResult.class)
                    || targetMethod.isAnnotationPresent(ResponseResult.class)) {
                obj = Result.fail(ResultCode.SERVER_FLOW_ERROR);
            }else{
                throw e;
            }
        }
        catch (GlobalHandleException e) {
            e.printStackTrace();
            log.error(e.getMessage() + e);
            if (clazz.isAnnotationPresent(ResponseResult.class)
                    || targetMethod.isAnnotationPresent(ResponseResult.class)) {
                obj = Result.fail(e.getResultCode());
            }else{
                throw e;
            }
        } catch (Throwable e){
            e.printStackTrace();
            log.error(e.getMessage() + e);
            if (clazz.isAnnotationPresent(ResponseResult.class)
                    || targetMethod.isAnnotationPresent(ResponseResult.class)) {
                obj = Result.fail(ResultCode.SERVER_UNKNOW_ERROR);
            }else{
                throw e;
            }
        }

        return obj;
    }
    private boolean isAnnotationPresent(Class clazz,Method method){
        return clazz.isAnnotationPresent(ResponseResult.class)
                || method.isAnnotationPresent(ResponseResult.class);

    }
}
