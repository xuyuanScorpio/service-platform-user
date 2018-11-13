package com.service.platform.user.facade.impl;

import com.service.platform.user.domain.request.ModifiyMobileRequest;
import com.service.platform.user.domain.request.ModifiyUserInfoRequest;
import com.service.platform.user.domain.request.ResetPasswordRequest;
import com.service.platform.user.domain.request.UserRequest;
import com.service.platform.user.facade.UserFacadeService;
import com.service.platform.user.service.UserService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeServiceImpl implements UserFacadeService.Iface {

    @Override
    public String checkMobileIsRegist(String mobile) throws TException {
        return userService.checkMobileIsRegist(mobile);
    }

    @Override
    public String userRegister(UserRequest userRequest) throws TException {
        return userService.userRegister(userRequest);
    }

    @Override
    public String login(UserRequest userRequest) throws TException {
        return userService.login(userRequest);
    }

    @Override
    public String resetPassword(ResetPasswordRequest resetPassowrdRequest) throws TException {
        return userService.resetPassword(resetPassowrdRequest);
    }

    @Override
    public String modifiyUserInfo(ModifiyUserInfoRequest modifiyUserInfoRequest) throws TException {
        return userService.modifiyUserInfo(modifiyUserInfoRequest);
    }

    @Override
    public String modifiyMobile(ModifiyMobileRequest modifiyMobileRequest) throws TException {
        return userService.modifiyMobile(modifiyMobileRequest);
    }

    @Override
    public String getUserInfo(String id) throws TException {
        return userService.getUserInfo(id);
    }

    @Override
    public String logout(String id) throws TException {
        return userService.logout(id);
    }

    @Autowired
    private UserService userService;
}
