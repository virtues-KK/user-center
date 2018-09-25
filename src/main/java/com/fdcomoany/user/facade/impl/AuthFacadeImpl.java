package com.fdcomoany.user.facade.impl;


import com.fdcomoany.user.facade.AuthFacade;
import com.fdcomoany.user.facade.bean.JwtUser;
import com.fdcomoany.user.remote.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFacadeImpl implements AuthFacade {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    public SecurityService securityService;

    @Override
    public JwtUser getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        final String requestHeader = request.getHeader(this.tokenHeader);
        if (null != requestHeader) {
            return securityService.getUser();
        }
        return null;
    }

}
