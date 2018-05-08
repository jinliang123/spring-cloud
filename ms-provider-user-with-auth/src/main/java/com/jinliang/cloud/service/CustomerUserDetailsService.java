package com.jinliang.cloud.service;

import com.jinliang.cloud.domain.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Auther: jinliang
 * Date: 2018/5/8 13:18
 * Description:
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)){
            return new SecurityUser("user","password1","user-role");
        }else if("admin".equals(username)){
            return new SecurityUser("admin","password2","admin-role");
        }
        return null;
    }
}
