package com.fdcomoany.user.entity.embed;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 地址类
 * 可嵌入式对象
 */
@Embeddable
@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Address implements Serializable {

//    @ManyToOne
//    @JoinColumn
//    private Province province;//省

//    @ManyToOne
//    @JoinColumn
//    private City city;//市
//
//    @ManyToOne
//    @JoinColumn
//    private District district;//区

}
