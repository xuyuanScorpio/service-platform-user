package com.service.platform.user.common.validate.impl;

import com.service.platform.user.common.domain.BaseRequest;
import com.service.platform.user.common.properties.SecurityProperties;
import com.service.platform.user.common.validate.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;

public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {


    @Override
    public void create(BaseRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * 保存校验码
     *
     * @param request
     * @param validateCode
     */
    private void save(BaseRequest request, C validateCode) {
        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
        validateCodeRepository.save(request.getUserPhone(), code, ValidateCodeType.valueOf(request.getRequestType().toUpperCase()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void validate(BaseRequest request) {

        ValidateCodeType codeType = ValidateCodeType.valueOf(request.getRequestType().toUpperCase());

        C codeInRedis = (C) validateCodeRepository.get(request.getUserPhone(), codeType);

        String codeInRequest;
        codeInRequest = request.getVerificationCode();

        if (StringUtils.isBlank(codeInRequest)) {
            throw new RuntimeException(codeType + "请填写验证码");
        }

        if (codeInRedis == null) {
            throw new RuntimeException(codeType + "验证码不存在");
        }

        if (codeInRedis.isExpried()) {
            validateCodeRepository.remove(request.getUserPhone(), codeType);
            throw new RuntimeException(codeType + "验证码已过期，请重新获取");
        }

        if (!StringUtils.equals(codeInRedis.getCode(), codeInRequest)) {
            throw new RuntimeException(codeType + "验证码不正确");
        }
        validateCodeRepository.remove(request.getUserPhone(), codeType);

    }

    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(BaseRequest request, C validateCode) throws Exception;

    private C generate(BaseRequest request){

        String type = request.getRequestType().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new RuntimeException("验证码生成器" + generatorName + "不存在");
        }
        return (C) validateCodeGenerator.generate(request);

    }

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

}
