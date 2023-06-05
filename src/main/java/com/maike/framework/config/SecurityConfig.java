/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 5/27/23 00:13
 * description: 做什么的？
 */
package com.maike.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().and().authorizeRequests().anyRequest().authenticated();
    }
}
