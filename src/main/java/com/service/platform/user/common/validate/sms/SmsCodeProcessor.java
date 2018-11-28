package com.service.platform.user.common.validate.sms;

import com.service.platform.user.common.domain.BaseRequest;
import com.service.platform.user.common.validate.ValidateCode;
import com.service.platform.user.common.validate.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor {


    @Override
    public void send(BaseRequest request, ValidateCode validateCode) throws Exception {
        String mobile = request.getUserPhone();
        smsCodeSender.send(mobile, validateCode.getCode());
    }

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;

}
