package com.jinliang.cloud.controller;

import com.jinliang.cloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jinliang on 2017/11/24.
 */
@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:8000/"+id,User.class);
    }
}
