package com.fdcomoany.user.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 公共的用户信息
 *
 * @author zxy
 * @date 2018-09-13 17:24
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class CommonUserInfo {

    /**
     * 通过id 关联 安全服务中的id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 电话号码
     */
    @Column(unique = true, length = 44)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn
    private Province province;//省

    @ManyToOne
    @JoinColumn
    private City city;//市

    @ManyToOne
    @JoinColumn
    private District district;//区

    /**
     * 是否为有效用户
     */
    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean isValid;

    /**
     * 微信openId
     */
    private String wechatOpenId;

    @ManyToOne
    @JoinColumn
    private School school;

    @ColumnDefault("true")
    private Boolean gender;

    private String startYear;

    /**
     * 用户等级
     */
    @Enumerated
    private Level level;

    private Long userId;

    private String name;

    private String nickName;

    private String image;

    public enum Level {

        ZHI_YUAN,
        FULL_FEATURED

    }
}
