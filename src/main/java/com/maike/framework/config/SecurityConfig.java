/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 5/27/23 00:13
 * description: 做什么的？
 */
package com.maike.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                .permitAll()
                .antMatchers("/**").anonymous()
                .antMatchers("/admin/**").hasAnyRole("admin","common")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3")
                //设置所有认证后的用户都能够访问所有接口，不需要任何权限
                .anyRequest().authenticated()
                //设置不需要登陆认证就能够访问登陆接口
                .and()
                .formLogin()
                .permitAll()
                // 设置不需要登陆认证就能够访问登出接口
                .and()
                .logout()
                .permitAll();
        //httpSecurity.formLogin().and().authorizeRequests().anyRequest().authenticated();
        //没有权限会默认到登录页,需要开启登录的页面
        //login
        //定制根页面，user为表单中username的name，pwd为表单中password的name
        //loginProcessingUrl为表单跳转路径，若无这个，则跳转路径为toLogin
        //httpSecurity.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");

        //防止网站攻击： get,post
        httpSecurity.csrf().disable();//关闭csrf功能，登出失败可能存在的原因
        //注销，开启了注销功能，跳到首页
        httpSecurity.logout().logoutSuccessUrl("/");

        //开启记住我功能   cookie  默认保存时间14天
        //自定义接收前端参数，remember为表单中的名字
        //httpSecurity.rememberMe().rememberMeParameter("remember");
    }

    //认证
    //密码编码：PasswordEncoder
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //这些数据正常应该从数据库中读
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("lzj").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
//                .and()
//                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
//
//    }
}
