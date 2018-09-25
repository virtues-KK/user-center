package com.fdcomoany.user.remote.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignHeadersInterceptor implements RequestInterceptor {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            final String requestHeader = request.getHeader(this.tokenHeader);
//
            if (null != requestHeader) {
                requestTemplate.header(this.tokenHeader, requestHeader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
