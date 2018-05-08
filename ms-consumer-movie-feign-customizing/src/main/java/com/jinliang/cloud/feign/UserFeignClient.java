package com.jinliang.cloud.feign;

import com.jinliang.cloud.config.FeignConfiguration;
import com.jinliang.cloud.domain.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Auther: jinliang
 * Date: 2018/5/8 10:37
 * Description:
 */
@FeignClient(name = "ms-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
