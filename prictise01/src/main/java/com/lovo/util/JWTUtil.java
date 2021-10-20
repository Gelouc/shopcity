package com.lovo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lovo.result.GlobalHandleException;
import com.lovo.result.ResultCode;

import java.util.Calendar;
import java.util.Date;

public class JWTUtil {
    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字，这个人的昵称
     * 加密密钥：这个人的id加上一串字符串
     */
    public static String createToken(String userId,String password,int timeType,int timeValue) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(timeType,timeValue);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId.toString())   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .sign(Algorithm.HMAC256(password));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     * @param token
     * @throws GlobalHandleException
     */
    public static void verifyToken(String token, String secret) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = verifier.verify(token);
    }

    /**
     * 获取签发对象，签发对象就是用户的ID
     */
    public static String getAudience(String token) throws GlobalHandleException {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            throw new GlobalHandleException(ResultCode.USER_AUTHENTICATION_ERROR);
        }
        return audience;
    }
}