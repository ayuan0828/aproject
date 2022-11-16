package com.example.aproject.controller;

import com.example.aproject.beans.HttpResponseEntity;
import com.example.aproject.beans.UserEntity;
import com.example.aproject.common.Constans;
import com.example.aproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 前端控制器--实现用户操作
 */
@RestController
@RequestMapping("/admin")

public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/userLogin",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity userLogin(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        //1.获取用户名
        String username = map.get("username").toString();
        //2.获取密码
        String password = map.get("password").toString();
        //3.调用业务逻辑层验证登录用户的有效性
        UserEntity userEntity =  userService.findUserByName(username);
        //4.响应客户端的异步请求
        if(userEntity==null ){
            httpResponseEntity.setCode(Constans.USER_CODE);
            httpResponseEntity.setMessage(Constans.LOGIN_USERNAME_MESSAGE);
        }else if(password.equals(userEntity.getPassword())){
            // 合法用户
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage(Constans.LOGIN_MESSAGE);
            httpResponseEntity.setData(userEntity);
        }else{
            // 不合法用户
            httpResponseEntity.setCode(Constans.EXIST_CODE);
            httpResponseEntity.setMessage(Constans.LOGIN_PASSWORD_MESSAGE);

        }
        return httpResponseEntity;
    }
}
