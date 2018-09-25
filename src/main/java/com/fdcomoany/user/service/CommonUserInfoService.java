package com.fdcomoany.user.service;


import com.fdcomoany.user.entity.CommonUserInfo;
import com.fdcomoany.user.entity.UpdateUserInfoRequest;
import com.fdcomoany.user.repository.CommonUserInfoRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author zxy
 * @date 2018-09-14 18:03
 */
@Service
public class CommonUserInfoService {

    @Autowired
    private CommonUserInfoRepository commonUserInfoRepository;

    @Transactional
    public void updateWechatOpenIdByPhoneNumber(String phoneNumber,String wechatOpenId){
        commonUserInfoRepository.updatePhoneNumber(phoneNumber,wechatOpenId);
    }

    public CommonUserInfo searchByUserId(long userId){
        final Optional<CommonUserInfo> commonUserInfoOptional = commonUserInfoRepository.findByUserId(userId);
        if (commonUserInfoOptional.isPresent()){
            final CommonUserInfo commonUserInfo = commonUserInfoOptional.get();
            Hibernate.initialize(commonUserInfo.getCity());
            Hibernate.initialize(commonUserInfo.getDistrict());
            Hibernate.initialize(commonUserInfo.getProvince());
            Hibernate.initialize(commonUserInfo.getSchool());
            return commonUserInfoOptional.get();
        }
        return null;
    }

    public CommonUserInfo updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest) {
        CommonUserInfo old = commonUserInfoRepository.getOne(updateUserInfoRequest.getId());
        BeanUtils.copyProperties(updateUserInfoRequest,old);
        return commonUserInfoRepository.save(old);
    }

    public void updateLevelAndIsValid(CommonUserInfo commonUserInfo) {
        CommonUserInfo old = commonUserInfoRepository.getOne(commonUserInfo.getId());
        old.setLevel(commonUserInfo.getLevel());
        old.setIsValid(commonUserInfo.getIsValid());
        commonUserInfoRepository.save(old);
    }

    public void updateOpenId(CommonUserInfo commonUserInfo) {
        CommonUserInfo old = commonUserInfoRepository.getOne(commonUserInfo.getId());
        old.setWechatOpenId(commonUserInfo.getWechatOpenId());
        System.out.println(old);
        commonUserInfoRepository.save(old);
    }

    public CommonUserInfo searchByPhoneNumber(String phoneNumber) {
        final CommonUserInfo commonUserInfo = commonUserInfoRepository.findByPhoneNumber(phoneNumber);
        if (commonUserInfo!=null){
            Hibernate.initialize(commonUserInfo.getCity());
            Hibernate.initialize(commonUserInfo.getDistrict());
            Hibernate.initialize(commonUserInfo.getProvince());
            Hibernate.initialize(commonUserInfo.getSchool());
        }
        return commonUserInfo;
    }
}