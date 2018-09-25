package com.fdcomoany.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @className:city
 * @time:7/19
 * @author:潘乐
 * @description:城市的基本类,多对一向上关联省份
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    /**
     * 城市编号
     */
    @Id
    private Long id;

    /**
     * 城市名
     */
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private List<District> districts;
}

