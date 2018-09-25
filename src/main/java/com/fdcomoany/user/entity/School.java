package com.fdcomoany.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * className:School
 * time:7/19
 * author:潘乐
 * description:学校的基本类,多对一向上关联区,城市,省份
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

    /**
     * 学校编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 学校名
     */
    private String name;

    /**
     * 关联的区域
     */
    @ManyToOne(fetch=FetchType.LAZY)
    private District district;

    /**
     * 关联的城市
     */
    @ManyToOne(fetch=FetchType.LAZY)
    private City city;

    /**
     * 关联的省份
     */
    @ManyToOne(fetch=FetchType.LAZY)
    private Province province;

}
