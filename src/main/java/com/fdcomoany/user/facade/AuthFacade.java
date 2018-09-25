package com.fdcomoany.user.facade;


import com.fdcomoany.user.facade.bean.JwtUser;

public interface AuthFacade {
    JwtUser getCurrentUser();
}
