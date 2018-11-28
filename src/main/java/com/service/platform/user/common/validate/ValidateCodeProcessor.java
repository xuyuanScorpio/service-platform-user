package com.service.platform.user.common.validate;

import com.service.platform.user.common.domain.BaseRequest;

public interface ValidateCodeProcessor {


    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(BaseRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param request
     * @throws Exception
     */
    void validate(BaseRequest request);



}
