package com.jinliang.cloud.controller;

import com.jinliang.cloud.domain.User;
import com.jinliang.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinliang on 2017/11/24.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }
}
