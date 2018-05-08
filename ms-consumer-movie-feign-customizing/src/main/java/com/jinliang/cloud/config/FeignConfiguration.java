package com.jinliang.cloud.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auther: jinliang
 * Date: 2018/5/8 11:01
 * Description: Feign的配置类
 */
@Configuration
public class FeignConfiguration {

    /**
     * 指定契约为Feign默认的契约，这样可以使用feign自带的注解。
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    /**
     * 接口需要进行HttpBasic的认证后才可以使用
     * @return
     */

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }

}
