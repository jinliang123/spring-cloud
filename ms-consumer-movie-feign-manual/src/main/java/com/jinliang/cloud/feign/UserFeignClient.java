package com.jinliang.cloud.feign;

import com.jinliang.cloud.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Auther: jinliang
 * Date: 2018/5/8 10:37
 * Description:
 */
@FeignClient(name = "ms-provider-user")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
