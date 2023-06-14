/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 6/14/23 23:30
 * description: 做什么的？
 */
package com.maike.framework.web;

import com.maike.webapp.function.domain.GpUser;
import com.maike.webapp.function.domain.SysUser;
import com.maike.webapp.function.service.GpUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

public class CustomUserDetailService implements UserDetailsService {

    @Resource
    private GpUserService gpUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GpUser gpUser=new GpUser();
        gpUser.setUserName(username);
        SysUser user = gpUserService.selectGpUserByGpUser(gpUser);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+username);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
