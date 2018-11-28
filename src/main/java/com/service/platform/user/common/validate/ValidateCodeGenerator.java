package com.service.platform.user.common.validate;

import com.service.platform.user.common.domain.BaseRequest;

public interface ValidateCodeGenerator {

    /**
     *
     * 生成校验码
     * @return
     */
    ValidateCode generate(BaseRequest request);

}
