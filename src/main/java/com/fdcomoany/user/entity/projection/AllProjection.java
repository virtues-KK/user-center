package com.fdcomoany.user.entity.projection;

import com.fdcomoany.user.entity.*;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author zxy
 * @date 2018-09-18 17:43
 */
@Projection(types = {CommonUserInfo.class}, name = "all")
public interface AllProjection {

    Long getId();

    String getPhoneNumber();

    Province getProvince();

    City getCity();

    District getDistrict();

    Boolean getIsValid();

    String getWechatOpenId();

    School getSchool();

    Boolean getGender();

    Integer getStartYear();

    CommonUserInfo.Level getLevel();

    Long getUserId();

    String getName();

    String getNickName();

    String getImage();

}
