package com.service.platform.user.common.validate.cache;

import com.service.platform.user.common.validate.ValidateCode;
import com.service.platform.user.common.validate.ValidateCodeRepository;
import com.service.platform.user.common.validate.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 基于redis的验证码存取器
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Override
    public void save(String keySuffix, ValidateCode code, ValidateCodeType type) {
        redisTemplate.opsForValue().set(keySuffix ,code,1, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(String keySuffix, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(keySuffix, type));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(String keySuffix, ValidateCodeType type) {

        redisTemplate.delete(buildKey(keySuffix, type));

    }


    /**
     * @param keySuffix
     * @param type
     * @return
     */
    private String buildKey(String keySuffix, ValidateCodeType type) {

        if (StringUtils.isBlank(keySuffix)) {
//            throw new ValidateCodeException("请在请求头中携带deviceId参数");
            throw new RuntimeException("请求后缀不能为空！");
        }
        return "code:" + type.toString().toLowerCase() + ":" + keySuffix;
    }



    @Autowired
    private RedisTemplate redisTemplate;
}
