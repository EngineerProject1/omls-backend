package com.cuit9622.auth.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cuit9622.auth.util.JWTUtils;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.utils.RedisUtils;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 自定义JwtRealm实现jwt登录
 */
@Component
@Slf4j(topic = "JwtRealm")
public class JwtRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @Description 配置该Realm只支持JwtToken
     * @return
     */
    @Override
    public Class<?> getAuthenticationTokenClass() {
        return JwtToken.class;
    }

    /**
     * @Description 自定义授权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户名
        User user = ((User) principals.getPrimaryPrincipal());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 封装角色信息
        List<String> roles = userService.getUserRoleByName(user.getUsername());
        info.addRoles(roles);
        return info;
    }

    /**
     * @Description 自定义登录认证方法
     * @param token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken jwtToken) throws AuthenticationException {
        // 获取token并进行验证
        String token = (String) jwtToken.getPrincipal();

        DecodedJWT verify = JWTUtils.verify(token);
        String username = verify.getSubject();
        // 从redis中取出token进行比对
        String tokenByRedis = (String) redisTemplate.opsForValue().get(RedisUtils.JWT_TOKEN + username);
        String usernameByRedis = JWTUtils.verify(tokenByRedis).getSubject();
        if (!StringUtils.equals(tokenByRedis, token) || !StringUtils.equals(usernameByRedis, username)) {
            throw new BizException("token异常");
        }
        User user = userService.getUserInfoByName(username);
        log.info("认证完成");
        return new SimpleAuthenticationInfo(user, Boolean.TRUE, getName());
    }
}
