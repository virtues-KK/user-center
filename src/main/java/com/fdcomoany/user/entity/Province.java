package com.fdcomoany.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @time:7/19
 * @author:潘乐
 * @description:省份的基本类
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Province {

    /**
     * 省编号
     */
    @Id
    private Long id;

    /**
     * 省名
     */
    private String name;

    @OneToMany(fetch = FetchType.LAZY )
    @JoinColumn(name = "province_id")
    private List<City> cities;

}
