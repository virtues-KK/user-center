package com.fdcomoany.user.entity;

import lombok.Data;

/**
 * @author zxy
 * @date 2018-09-18 21:29
 */
@Data
public class UpdateUserInfoRequest {

    private Long id;

    private String startYear;

    private String name;

    private Boolean gander;

    private Province province;

    private City city;

    private School school;

    private District district;

}
