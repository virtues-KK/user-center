package com.fdcomoany.user.remote;


import com.fdcomoany.user.facade.bean.JwtUser;
import com.fdcomoany.user.remote.Hystrix.SecurityHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "cloud-server-security",
        url = "http://39.104.165.143:30010",
        path = "/login",
        fallback = SecurityHystrix.class
)
public interface SecurityService {

    @RequestMapping(
            value = "/auth/user",
            method = RequestMethod.GET
    )
    JwtUser getUser();

}
