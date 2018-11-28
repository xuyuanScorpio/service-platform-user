package com.service.platform.user.common.validate;

public interface ValidateCodeRepository {


    void save(String keySuffix, ValidateCode code, ValidateCodeType type);

    ValidateCode get(String keySuffix, ValidateCodeType type);

    void remove(String keySuffix, ValidateCodeType type);
}
