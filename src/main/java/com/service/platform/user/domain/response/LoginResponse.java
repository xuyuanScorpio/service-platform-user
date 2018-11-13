package com.service.platform.user.domain.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private String id;

    private int loginFailedNum;

    public LoginResponse(){

    }

    public LoginResponse(int loginFailedNum) {
        this.loginFailedNum = loginFailedNum;
    }

    public LoginResponse(String id) {
        this.id = id;
    }

    public LoginResponse(String id, int loginFailedNum) {
        this.id = id;
        this.loginFailedNum = loginFailedNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLoginFailedNum() {
        return loginFailedNum;
    }

    public void setLoginFailedNum(int loginFailedNum) {
        this.loginFailedNum = loginFailedNum;
    }
}
