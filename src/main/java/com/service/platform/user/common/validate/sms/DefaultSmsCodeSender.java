package com.service.platform.user.common.validate.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) throws Exception {

        logger.warn("请配置真实的短信验证码发送器(SmsCodeSender)");
        logger.info("向手机"+mobile+"发送短信验证码"+code);

    }

    private Logger logger = LoggerFactory.getLogger(getClass());
}
