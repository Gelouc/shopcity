package com.lovo.controller;

import com.lovo.bean.UserBean;
import com.lovo.mapper.IUserMapper;
import com.lovo.result.GlobalHandleException;
import com.lovo.result.ResponseResult;
import com.lovo.result.ResultCode;
import com.lovo.result.UserValid;
import com.lovo.service.IUserService;
import com.lovo.util.JWTUtil;
import com.lovo.util.UploadUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService service;
    @Resource
    private IUserMapper mapper;

    @PostMapping("/add")
    @ResponseBody
    @ResponseResult
    public Object add(UserBean user) {
        service.add(user);
        return "ok";
    }

    @GetMapping
    public Object selectAll(Integer pageNO){
        return service.selectAll(pageNO);
    }

    @ApiOperation("登录方法")
    @PostMapping("/login")
    @ResponseResult
    public Object login( String code, String pwd) throws GlobalHandleException {
//        UserBean user = mapper.findByCodeAndPwd(code,DigestUtils.sha256Hex(pwd));
//        if(user == null){
//            throw new GlobalHandleException(ResultCode.USER_LOGIN_ERROR);
//        }
////        session.setAttribute("user",user);
////        String str = JWTUtil.createToken(user.getId().toString(),user.getPwd());
////        return str;
//        String token = JWTUtil.createToken(user.getId().toString(),user.getPwd(), Calendar.SECOND,10);
//        String refreshToken = JWTUtil.createToken(user.getId().toString(),user.getPwd(), Calendar.DATE,7);
//        Map map = new HashMap();
//        map.put("token",token);
//        map.put("refreshToken",refreshToken);
//        return map;
        // 把用户输入的账号和密码封装到shiro框架提供的token对象中
        UsernamePasswordToken token = new UsernamePasswordToken(code, DigestUtils.sha256Hex(pwd));
        Subject currentUser = SecurityUtils.getSubject();
        try{
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        }catch(IncorrectCredentialsException ice){
            throw new GlobalHandleException(ResultCode.USER_PASS_ERROR);
        }catch (UnknownAccountException uae){
            throw new GlobalHandleException(ResultCode.USER_NOT_EXIST);
        }catch (AuthenticationException ae){
            throw new GlobalHandleException(ResultCode.USER_AUTHENTICATION_ERROR);
        }catch (AuthorizationException ae){
            throw new GlobalHandleException(ResultCode.USER_AUTHORIZATION_ERROR);
        }
        return currentUser.getPrincipal();
    }

    @GetMapping("/removeSession")
    public Object removeSession(HttpSession session){
        session.setAttribute("user",null);
        return null;
    }

    /**
     * 从session中获取用户对象
     * @return
     */
    @GetMapping("/session")
    @UserValid
    @ResponseResult
    public Object getUserWithSession(HttpSession session){
        Object user = session.getAttribute("user");
        return user;
    }

    /**
     * 从session中获取用户对象
     * @return
     */
    @GetMapping("/token")
    @UserValid
    @ResponseResult
    public Object getUserWithToken(HttpServletRequest request){
        return request.getAttribute("user");
    }

    @GetMapping("/refreshToken")
    @UserValid
    public Object refreshToken(HttpServletRequest request){
        UserBean userInfoBean = (UserBean) request.getAttribute("user");
        return JWTUtil.createToken(userInfoBean.getId().toString(),userInfoBean.getPwd(),Calendar.SECOND,10);
    }
}
