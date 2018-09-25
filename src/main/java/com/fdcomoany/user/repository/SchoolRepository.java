package com.fdcomoany.user.repository;


import com.fdcomoany.user.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zxy
 * @date 2018-09-17 19:43
 */
public interface SchoolRepository extends JpaRepository<School,Long> {

    List<School> findByDistrict_Id(@Param("districtId") Long districtId);

}
