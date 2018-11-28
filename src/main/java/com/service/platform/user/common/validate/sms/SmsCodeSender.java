package com.service.platform.user.common.validate.sms;

public interface SmsCodeSender {

    void send(String mobile, String code) throws Exception;

}
