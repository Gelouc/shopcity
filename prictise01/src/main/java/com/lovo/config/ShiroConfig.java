package com.lovo.config;

import com.lovo.shiro.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 配置Shiro核心 安全管理器 SecurityManager
     * SecurityManager安全管理器：所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject；负责与后边介绍的其他组件进行交互。（类似于SpringMVC中的DispatcherServlet控制器）
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //将自定义的realm交给SecurityManager管理
        securityManager.setRealm(customRealm());
        return securityManager;
    }
    /**
     * 配置Shiro的Web过滤器，拦截浏览器请求并交给SecurityManager处理
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean webFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置拦截链 使用LinkedHashMap,因为LinkedHashMap是有序的，shiro会根据添加的顺序进行拦截
        // Map<K,V> K指的是拦截的url V值的是该url是否拦截
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>(16);
        // 配置不需要进行身份认证的路径，其中anon表示不需要认证
        filterChainMap.put("/users/login", "anon");
        filterChainMap.put("/swagger-ui.html", "anon");
        filterChainMap.put("/webjars/**", "anon");
        filterChainMap.put("/swagger-resources/**", "anon");
        filterChainMap.put("/v2/api-docs", "anon");
        // 配置需要进行身份认证的路径。/**表示所有路径
        filterChainMap.put("/**", "authc");
        // 当认证失败后跳转的路径
        shiroFilterFactoryBean.setLoginUrl("/authentication_fail");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;

    }
    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }

}