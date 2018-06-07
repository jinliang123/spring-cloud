package com.jinliang.cloud.feign.impl;

import com.jinliang.cloud.domain.User;
import com.jinliang.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Service;

/**
 * Auther: jinliang
 * Date: 2018/5/8 18:46
 * Description:
 */
@Service
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
