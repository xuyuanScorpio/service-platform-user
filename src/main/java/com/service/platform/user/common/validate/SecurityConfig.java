package com.service.platform.user.common.validate;

public class SecurityConfig {

    private ValidateCodeConfig code = new ValidateCodeConfig();

    public ValidateCodeConfig getCode() {
        return code;
    }

    public void setCode(ValidateCodeConfig code) {
        this.code = code;
    }
}
