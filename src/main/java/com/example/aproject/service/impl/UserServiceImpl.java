package com.example.aproject.service.impl;

import com.example.aproject.beans.UserEntity;
import com.example.aproject.dao.UserEntityMapper;
import com.example.aproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能：业务逻辑层实现子类
 *          实现用户操作
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * 功能：注入数据库访问层对象
     */
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity findUserByName(String username) {
        return userEntityMapper.findUserByName(username);
    }

}
