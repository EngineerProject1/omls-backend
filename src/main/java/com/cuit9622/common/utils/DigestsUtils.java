package com.cuit9622.common.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 加密工具类
 */
public class DigestsUtils {

    // 加密算法
    public static final String ALG = "SHA-1";

    // 迭代次数
    public static final Integer ITERATIONS = 520;

    /**
     * @Description 讲明文根据盐值进行SHA-1加密
     * @param text 明文
     * @param salt 加密盐
     * @return 密文
     */
    public static String sha1(String text, String salt) {
        return new SimpleHash(ALG, text, salt, ITERATIONS).toString();
    }

    /**
     * @Description 随机生成加密盐值
     * @return 盐值
     */
    public static String createSalt() {
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        return generator.nextBytes().toString();
    }

    /**
     * @Description 返回map，map里有密文和加密盐值
     * @param text 明文
     * @return map集合
     */
    public static Map<String, String> encrypt(String text) {
        Map<String, String> map = new HashMap<>();
        String salt = createSalt();
        String password = sha1(text, salt);
        map.put("salt", salt);
        map.put("password", password);
        return map;
    }
}
