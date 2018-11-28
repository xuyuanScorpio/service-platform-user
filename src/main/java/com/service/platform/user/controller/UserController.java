package com.service.platform.user.controller;

import com.service.platform.user.domain.*;
import com.service.platform.user.domain.request.*;
import com.service.platform.user.domain.response.Response;
import com.service.platform.user.service.UserService;
import com.service.platform.user.thriftClient.domain.ThriftClient;
import com.service.platform.user.utils.GsonUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @RequestMapping("register")
    public String register(){

        try {
            thriftClient.open();
            RegisterIdCenterRequest request = new RegisterIdCenterRequest();
            request.setHeader("");
            request.setLength(6);
            String result = thriftClient.getGenerateIdService().registerIdCenter(request);

            Response response = GsonUtil.toBean(result, Response.class);

            return result;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
        return "xyking";
    }

    @RequestMapping("generateId")
    public Response generateId(){
        Response response = null;
        try {
            thriftClient.open();
            GenerateIdRequest request = new GenerateIdRequest();
            request.setHeader("");
            request.setType(RequestType.Disorder);
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

    @GetMapping("getUserInfo/{id}")
    public String getUserInfo(@PathVariable String id){
        return userService.getUserInfo(id);
    }

    @GetMapping("checkMobile/{mobile}")

    public String checkMobile(@PathVariable String mobile){

        return userService.checkMobileIsRegist(mobile);
    }

    @PostMapping("userRegiseter")
    public String userRegiseter(@RequestBody UserRequest userRequest){

        return userService.userRegister(userRequest);
    }

    @PutMapping("resetPassword")
    @ApiOperation(value="重置用户密码", notes="根据用户手机号重置用户登录密码")
    public String resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){

        return userService.resetPassword(resetPasswordRequest);
    }

    @PutMapping("modifyMobile")
    public String modifyMobile(@RequestBody ModifiyMobileRequest modifiyMobileRequest){

        return userService.modifiyMobile(modifiyMobileRequest);
    }

    @PutMapping("modifyUserInfo")
    public String modifyUserInfo(@RequestBody ModifiyUserInfoRequest modifiyUserInfoRequest){

        return userService.modifiyUserInfo(modifiyUserInfoRequest);
    }

    @PostMapping("login")
    public String login(@RequestBody UserRequest userRequest){

        return userService.login(userRequest);
    }

    @GetMapping("logout/{id}")
    public String logout(@PathVariable String id){

        return userService.logout(id);
    }


    @GetMapping("sendSms/{phone}")
    public String sendSms(@PathVariable String phone){

        return userService.sendSms(phone);

    }

    @Autowired
    private UserService userService;



    @Autowired
    private ThriftClient thriftClient;
}
