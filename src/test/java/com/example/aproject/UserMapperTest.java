package com.example.aproject;


import com.example.aproject.beans.UserEntity;
import com.example.aproject.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能：单元测试用户操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Autowired
    private IUserService userService;

    @Test
    public void testMethod1(){
        System.out.println("hello ");
    }


    @Test
    public void testMethod2(){
        UserEntity userEntity = userService.findUserByName("admin12");
        if(userEntity!=null){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }

}
