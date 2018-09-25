package com.fdcomoany.user.repository;


import com.fdcomoany.user.entity.CommonUserInfo;
import com.fdcomoany.user.entity.projection.AllProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author zxy
 * @date 2018-09-14 10:19
 */
@RepositoryRestResource(path = "users",excerptProjection = AllProjection.class)
public interface CommonUserInfoRepository extends JpaRepository<CommonUserInfo, Long> {

    CommonUserInfo findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    Optional<CommonUserInfo> findByWechatOpenId(@Param("wechatOpenId") String wechatOpenId);

    Optional<CommonUserInfo> findByUserId(@Param("userId") long userId);

    @Modifying
    @Query("update CommonUserInfo set wechatOpenId = ?2 where phoneNumber = ?1")
    void updatePhoneNumber(
            String phoneNumber,
            String wechatOpenId
    );

}