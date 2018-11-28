package com.service.platform.user.common.validate.sms;

import com.service.platform.user.common.domain.BaseRequest;
import com.service.platform.user.common.properties.SecurityProperties;
import com.service.platform.user.common.utils.RandomUtils;
import com.service.platform.user.common.validate.ValidateCode;
import com.service.platform.user.common.validate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ValidateCode generate(BaseRequest request) {

        String code = RandomUtils.nextRandomNumber(securityProperties.getLength());

        return new ValidateCode(code, securityProperties.getExpireSecond());
    }


    @Autowired
    private SecurityProperties securityProperties;
}
