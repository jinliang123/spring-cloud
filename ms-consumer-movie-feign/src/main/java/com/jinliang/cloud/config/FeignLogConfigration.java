package com.jinliang.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auther: jinliang
 * Date: 2018/5/8 15:42
 * Description: Feign 日志配置类
 *
 */
@Configuration
public class FeignLogConfigration {

    /**
     *  NONE, 不记录任何日志，默认值
     *  BASIC,仅记录请求方法、URL、响应状态码
     *  HEADERS,记录BASIC级别的基础上，记录请求和响应的header
     *  FULL;记录请求和响应的header,body和元数据
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
