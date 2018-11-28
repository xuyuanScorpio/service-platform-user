package com.service.platform.user.common.domain;

public class BaseRequest {

    protected String requestType;

    protected String userPhone;

    protected String verificationCode;


    public BaseRequest() {
    }

    public BaseRequest(String requestType, String userPhone) {
        this.requestType = requestType;
        this.userPhone = userPhone;
    }

    public BaseRequest(String requestType, String userPhone, String verificationCode) {
        this.requestType = requestType;
        this.userPhone = userPhone;
        this.verificationCode = verificationCode;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
