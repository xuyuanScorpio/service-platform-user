package com.service.platform.user.service.impl;

import com.service.platform.user.common.domain.BaseRequest;
import com.service.platform.user.common.validate.sms.SmsCodeProcessor;
import com.service.platform.user.constants.Constant;
import com.service.platform.user.domain.RequestType;
import com.service.platform.user.domain.model.EntityUser;
import com.service.platform.user.domain.request.*;
import com.service.platform.user.domain.response.LoginResponse;
import com.service.platform.user.domain.response.Response;
import com.service.platform.user.mapper.EntityUserMapper;
import com.service.platform.user.service.UserService;
import com.service.platform.user.support.UserServiceSupport;
import com.service.platform.user.thriftClient.domain.ThriftClient;
import com.service.platform.user.utils.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {


    @Override
    public String checkMobileIsRegist(String mobile) {

        Response response;
        if(userServiceSupport.checkMobileIsRegist(mobile)){
            response = Response.error(Constant.LOGINNAME_EXSIST);
        }else {
            response = Response.ok();
        }
        return GsonUtil.toJson(response);
    }

    @Override
    @Transactional
    public String userRegister(UserRequest userRequest) {

        Response response;
        // 获取 userId
        GenerateIdRequest request = new GenerateIdRequest();
        request.setHeader("");
        request.setType(RequestType.Disorder);

        Response responseGenerateId = this.generateId(request);
        if(userServiceSupport.checkRPCResponse(responseGenerateId)){
            EntityUser userNew = new EntityUser();
            BeanUtils.copyProperties(userRequest, userNew);
            userNew.setId((String) responseGenerateId.getData());
            userNew.setCreateDate(new Date());
            // 生成userInfo
            // 插入数据库
            int effectCount = entityUserMapper.insertSelective(userNew);
            if(effectCount > 0){
                response =  Response.ok();
            }else {
                response = Response.error("注册失败! ");
            }
        }else{
            response = Response.error("注册失败! ");
        }
        return GsonUtil.toJson(response);

    }

    @Override
    public String login(UserRequest userRequest) {

        Response response;

        EntityUser user = entityUserMapper.selectEntityUserMobile(userRequest.getMobile());
        try {

            int loginFailedNum = user.getLoginFailedNum();

            // todo 校验验证码
            // 校验用户名和密码
            if(user.getPassword().equalsIgnoreCase(userRequest.getPassword())){
                user.setLoginFailedNum(0);
                user.setLastLoginTime(new Date());
                response = Response.ok(new LoginResponse(user.getId()));
            }else{
                // todo 记录登陆失败次数
                loginFailedNum++;
                response = Response.error("登陆失败！", new LoginResponse(loginFailedNum));
            }
        } finally {
            entityUserMapper.updateByPrimaryKeySelective(user);
        }

        return GsonUtil.toJson(response);


    }

    @Override
    public String resetPassword(ResetPasswordRequest resetPasswordRequest) {

        Response response;
        int result = 0;
        // 根据用户号获取用户信息
        EntityUser user = this.getEntityUserByMobile(resetPasswordRequest.mobile);
        //  todo 校验验证码

        if(null == user){
            response = Response.ok("该用户不存在！");
        }else{
            if(resetPasswordRequest.getNewPassword().equalsIgnoreCase(resetPasswordRequest.getVerifyPassword())){
                user.setPassword(resetPasswordRequest.newPassword);
                result = entityUserMapper.updateByPrimaryKeySelective(user);

                if(result > 0){
                    response = Response.ok("重置密码成功！");
                }else{
                    response = Response.error("重置密码失败！");
                }
            }else{
                response = Response.error("密码不一致！");
            }
        }
        return GsonUtil.toJson(response);
    }

    @Override
    public String modifiyMobile(ModifiyMobileRequest modifiyMobileRequest) {

        Response response;
        int result = 0;
        // 根据用户号获取用户信息

        if(userServiceSupport.checkMobileIsRegist(modifiyMobileRequest.getNewMobile())){
            response = Response.error("该手机号已经被注册！");
        }else {
            EntityUser user = this.getEntityUserById(modifiyMobileRequest.id);
            //  todo 校验验证码

            if(null == user){
                response = Response.ok("该用户不存在！");
            }else {
                user.setMobile(modifiyMobileRequest.getNewMobile());
                result = entityUserMapper.updateByPrimaryKeySelective(user);

                if (result > 0) {
                    response = Response.ok("更新手机成功！");
                } else {
                    response = Response.error("更新手机失败！");
                }
            }
        }

        return GsonUtil.toJson(response);
    }

    @Override
    public String sendSms(String phone) {

        BaseRequest request = new BaseRequest("sms", phone);

        try {
            smsCodeProcessor.create(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";


    }

    @Override
    public String modifiyUserInfo(ModifiyUserInfoRequest modifiyUserInfoRequest) {

        Response response;

        if(StringUtils.isBlank(modifiyUserInfoRequest.getName()) && StringUtils.isBlank(modifiyUserInfoRequest.getNickname())
                && StringUtils.isBlank(modifiyUserInfoRequest.getEmail())){
            response = Response.error("参数错误！");
        }else{
            int effectCount = entityUserMapper.updateUserInfo(modifiyUserInfoRequest);
            if (effectCount > 0) {
                response = Response.ok("更新用户信息成功");
            } else {
                response = Response.error("更新信息失败！");
            }
        }
        return GsonUtil.toJson(response);

    }

    @Override
    public String getUserInfo(String id) {
        Response response;
        EntityUser user = this.getEntityUserById(id);
        if(null != user){
            response = Response.ok(user);
        }else {
            response = Response.error("该用户不存在！");
        }

        return GsonUtil.toJson(response);
    }

    @Override
    public String logout(String id) {

        // 跟新 用户状态
        // 记录用户动作

        Response response;
        response = Response.ok("登出成功");

        return GsonUtil.toJson(response);

    }


    private Response generateId(GenerateIdRequest request) {
        Response response = null;
        try {
            thriftClient.open();
            String result = thriftClient.getGenerateIdService().generateId(request);
            response = GsonUtil.toBean(result, Response.class);

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
        return response;
    }

    @Cacheable(key="#userId + '_userInfo'")
    public EntityUser getEntityUserById(String id){
        return entityUserMapper.selectByPrimaryKey(id);
    }

    @Cacheable(key="#userMobile + '_userInfo'")
    public EntityUser getEntityUserByMobile(String mobile){
        return entityUserMapper.selectEntityUserMobile(mobile);
    }





//
//
//    @Override
//    @Transactional
//    public String modifiyUserInfo(UserRequest userRequest) {
//

//    }
//
//    @Override
//    public String getUserInfo(int id) {
//
//        Response response;
//        EntityUser user = this.getEntityUserById(id);
//        if(null != user){
//            response = Response.ok(user);
//        }else {
//            response = Response.error("该用户不存在！");
//        }
//
//        return GsonUtil.toJson(response);
//    }
//
//    @Override
//    public String login(LoginRequest loginRequest) {
//        Response response;
//        // 校验用户名和密码
//        EntityUser user = entityUserMapper1111.selectEntityUserByLoginName(loginRequest.getLoginName());
//        // todo 校验验证码
//        if(user.getPassword().equalsIgnoreCase(loginRequest.getPassword())){
//            response = Response.ok("登陆成功！");
//        }else{
//            // todo 记录登陆失败次数
//            response = Response.error("登陆失败！");
//        }
//
//        return GsonUtil.toJson(response);
//    }
//
//    @Override
//    public String logout(int id) {
//

//    }
//

//
//


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String CACHE_VALUE = "UserService-";


    @Autowired
    private SmsCodeProcessor smsCodeProcessor;

    @Autowired
    private UserServiceSupport userServiceSupport;

    @Autowired
    private EntityUserMapper entityUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ThriftClient thriftClient;


}
