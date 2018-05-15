package zool.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zoolye
 * Security安全配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*启用内存用户存储*/
        auth.inMemoryAuthentication()
                /*为内存用户存储添加新的用户*/
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*启用默认的登录页面*/
                .formLogin()
                .and()
                .authorizeRequests()
                /*指定对请求的路径需要认证*/
                .antMatchers("/complaint/index").authenticated()
                /*指定此路径的get请求需要认证*/
                .antMatchers(HttpMethod.POST,"/complaint").authenticated()
                /*其他的所有请求都是允许的*/
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                /*需要HTTPS*/
                .antMatchers("/complaint").requiresSecure();
    }
}
