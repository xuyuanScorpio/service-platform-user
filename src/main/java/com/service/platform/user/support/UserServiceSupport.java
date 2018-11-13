package com.service.platform.user.support;

import com.service.platform.user.domain.response.Response;
import com.service.platform.user.domain.response.ResponseCode;
import com.service.platform.user.mapper.EntityUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceSupport {

    public boolean checkMobileIsRegist(String mobile){

        return userMapper.selectCountByMobile(mobile) > 0;

    }

    public boolean checkRPCResponse(Response response){

        boolean result = false;

        if(null != response && response.getCode() == ResponseCode.SUCCESS.getCode()){
            result = true;
        }

        return result;
    }

    @Autowired
    private EntityUserMapper userMapper;
}
