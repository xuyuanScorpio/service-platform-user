package com.service.platform.user.service;

import com.service.platform.user.domain.request.ModifiyMobileRequest;
import com.service.platform.user.domain.request.ModifiyUserInfoRequest;
import com.service.platform.user.domain.request.ResetPasswordRequest;
import com.service.platform.user.domain.request.UserRequest;

public interface UserService {

    public String checkMobileIsRegist(String mobile);

    public String userRegister(UserRequest userRequest);

    public String login(UserRequest userRequest);

    public String resetPassword(ResetPasswordRequest resetPasswordRequest);

    public String modifiyUserInfo(ModifiyUserInfoRequest modifiyUserInfoRequest);

    public String getUserInfo(String id);

    public String logout(String id);

    public String modifiyMobile(ModifiyMobileRequest modifiyMobileRequest);

}
