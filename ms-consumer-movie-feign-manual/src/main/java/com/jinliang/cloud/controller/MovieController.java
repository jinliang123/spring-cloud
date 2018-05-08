package com.jinliang.cloud.controller;

import com.jinliang.cloud.domain.User;
import com.jinliang.cloud.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinliang on 2017/11/24.
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

    private UserFeignClient userUserFeignClient;
    private UserFeignClient adminUserFeignClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.userUserFeignClient= Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user","password1"))
                .target(UserFeignClient.class,"http://ms-provider-user-auth/");
        this.adminUserFeignClient= Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","password2"))
                .target(UserFeignClient.class,"http://ms-provider-user-auth/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id){
        return this.userUserFeignClient.findById(id);
    }
    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id){
        return this.adminUserFeignClient.findById(id);
    }

}
