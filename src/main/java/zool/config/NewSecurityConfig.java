package zool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
//@EnableWebSecurity//当我们需要自己扩展配置时，需要配置类继承WebSecurityConfigurerAdapter类即可，无需使用此注解
public class NewSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    DBSqlOA dbSqlOA;*/

    @Bean
    public UserDetailsService customUserService(){
        return new CustomUserService();
    }

    /**
     * 授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .formLogin().loginPage("/login")//formLogin定制登录操作，loginPage定制登录页面的访问地址
                .defaultSuccessUrl("/ws")//指定登录成功后转向的页面
                .failureUrl("/login?error")//指定登录失败后转向的页面
                .permitAll()
                .and()
                .rememberMe()//开启cookie储存用户信息
                .tokenValiditySeconds(1209600)//指定cookie有效期为1209600妙
                .key("myKey")//指定cookie中的私钥
                .and()
                .logout()//定制注销行为
                .logoutUrl("/custom-logout")//指定注销url
                .logoutSuccessUrl("/logout-success")//指定注销成功后转向的页面
                .permitAll();*/

        /*http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();*/


    }

    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth
                .inMemoryAuthentication()//添加在内存中的用户，并给用户指定角色权限
                .withUser("zool").password("123").roles("ROLE_ADMIN")
                .and()
                .withUser("zoolye").password("123456").roles("ROLE_USER");*/
        /*auth
                .jdbcAuthentication().dataSource(dbSqlOA.oaDataSource())
                .usersByUsernameQuery("select username,pswd from manage where username = ? and pswd = ?");*/

        auth.userDetailsService(customUserService());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }
}
