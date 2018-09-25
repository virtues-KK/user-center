package com.fdcomoany.user.remote.Hystrix;


import com.fdcomoany.user.facade.bean.JwtUser;
import com.fdcomoany.user.remote.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecurityHystrix implements SecurityService {

    @Override
    public JwtUser getUser() {
        log.error("error");
        return null;
    }
}
