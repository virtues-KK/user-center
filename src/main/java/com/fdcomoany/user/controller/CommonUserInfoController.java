package com.fdcomoany.user.controller;


import com.fdcomoany.user.entity.CommonUserInfo;
import com.fdcomoany.user.entity.UpdateUserInfoRequest;
import com.fdcomoany.user.facade.AuthFacade;
import com.fdcomoany.user.service.CommonUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zxy
 * @date 2018-09-14 10:25
 */
@RestController
@RequestMapping("users")
public class CommonUserInfoController {

    @Autowired
    private CommonUserInfoService commonUserInfoService;

    @Autowired
    private AuthFacade authFacade;

    @PostMapping("updateWechatOpenIdByPhoneNumber")
    public void updateWechatOpenIdByPhoneNumber(@RequestParam String phoneNumber, @RequestParam String wechatOpenId) {
        commonUserInfoService.updateWechatOpenIdByPhoneNumber(phoneNumber, wechatOpenId);
    }

    @PostMapping("updateUserInfo")
    public CommonUserInfo updateUserInfo(@RequestBody UpdateUserInfoRequest updateUserInfoRequest){
        return commonUserInfoService.updateUserInfo(updateUserInfoRequest);
    }

    @GetMapping("current")
    public CommonUserInfo getCurrentUserInfo(){
        final long userId = authFacade.getCurrentUser().getId();
        return commonUserInfoService.searchByUserId(userId);
    }

    @PostMapping(
            value = "/updateLevelAndIsValid"
    )
    public void updateLevelAndIsValid(@RequestBody CommonUserInfo commonUserInfo){
        commonUserInfoService.updateLevelAndIsValid(commonUserInfo);
    }

    @PostMapping(
            value = "/updateOpenId"
    )
    public void updateOpenId(@RequestBody CommonUserInfo commonUserInfo){
        commonUserInfoService.updateOpenId(commonUserInfo);
    }



//    @PostMapping
//    public CommonUserInfo save(@RequestBody CommonUserInfo commonUserInfo) {
//        return commonUserInfo.getId() == null
//                ? commonUserInfoService.save(commonUserInfo)
//                : commonUserInfoService.update(commonUserInfo);
//    }

    @GetMapping("search/findByPhoneNumber")
    public CommonUserInfo findByPhoneNumber(@RequestParam String phoneNumber) {
        return commonUserInfoService.searchByPhoneNumber(phoneNumber);
    }

}