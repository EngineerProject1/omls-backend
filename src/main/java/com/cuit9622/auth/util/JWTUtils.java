package com.cuit9622.auth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Author: lsh
 * Date: 2023/4/17 16:52
 * Version: 1.0
 * @Description: JWT工具类
 */
public class JWTUtils {
    // 私钥
    private static final String SECRET_KEY = "SJD(O!I@#()SKD<?X<?Z<D)P!@I#)_ISK>MD<Z>:K@_)#IO)_SI[KDL;AO)PQ@I#FKDJNFKL";

    /**
     * @Description 创建token
     * @param username 用户名
     * @param expire 过期时间
     * @return
     * @Date 16:53 2023/4/17
     */
    public static String creatToken(String username, Date expire) {

        JWTCreator.Builder builder = JWT.create();
        builder.withJWTId(UUID.randomUUID().toString())// 设置token唯一标识
                .withSubject(username) // 设置token的主体
                .withIssuer("9622")// 签发者
                .withIssuedAt(new Date()); //签发时间
        // 设置过期时间
        builder.withExpiresAt(expire);
        //签发
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    /**
     * @Description 含有map数据的token
     * @param map 数据集合
     * @param username 用户名
     * @param expire 过期时间
     * @return
     * @Date 13:30 2023/5/12
     */
    public static String creatToken(Map<String, Object> map, String username, Date expire) {

        JWTCreator.Builder builder = JWT.create();
        builder.withJWTId(UUID.randomUUID().toString())// 设置token唯一标识
                .withSubject(username) // 设置token的主体
                .withIssuer("9622")// 签发者
                .withIssuedAt(new Date()); //签发时间
        // 设置过期时间
        builder.withExpiresAt(expire);
        //签发
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    /**
     * @Description 解析token
     * @return
     * @Date 16:55 2023/4/17
     */
    public static DecodedJWT verify(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }
}
