package com.service.platform.user.mapper;

import com.service.platform.user.domain.model.EntityUser;
import com.service.platform.user.domain.request.ModifiyUserInfoRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface EntityUserMapper extends Mapper<EntityUser> {

    public int selectCountByMobile(String mobile);

    public EntityUser selectEntityUserMobile(String mobile);

    public int updateUserInfo(ModifiyUserInfoRequest modifiyUserInfoRequest);

}