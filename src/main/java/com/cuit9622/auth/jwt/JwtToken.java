package com.cuit9622.auth.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Author: lsh
 * Date: 2023/4/17 16:54
 * Version: 1.0
 * @Description: 自定义JWTtoken
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return Boolean.TRUE;
    }
}
