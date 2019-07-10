package com.cskaoyan.mall.admin.config;

import com.cskaoyan.mall.admin.shiro.MallShiroRealm;
import com.cskaoyan.mall.admin.shiro.MallShiroSessionManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 11:44
 * @description Shiro 配置类
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        return new MallShiroRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/admin/auth/login", "anon");
        filterChainDefinitionMap.put("/admin/auth/401", "anon");
        filterChainDefinitionMap.put("/admin/auth/index", "anon");
        filterChainDefinitionMap.put("/admin/auth/403", "anon");
        filterChainDefinitionMap.put("/admin/index/index", "anon");

        //filterChainDefinitionMap.put("/admin/auth/logout","logout");

        filterChainDefinitionMap.put("/wx/**", "anon");

        //filterChainDefinitionMap.put("/admin/**", "authc");
        shiroFilterFactoryBean.setLoginUrl("/admin/auth/401");
        shiroFilterFactoryBean.setSuccessUrl("/admin/auth/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/auth/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SessionManager sessionManager() {

        return new MallShiroSessionManager();
    }

    // 注册 securityManager：安全管理器
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
