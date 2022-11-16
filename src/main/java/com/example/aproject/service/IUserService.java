package com.example.aproject.service;

import com.example.aproject.beans.UserEntity;

/**
 * 功能：业务逻辑层实现用户的操作
 */
public interface IUserService {

    /**
     * 功能：验证登录用户的有效性
     * @param username
     * @return 根据用户名查询用户对象（用户名在数据表字段是唯一索引）
     */
    public UserEntity findUserByName(String username);
}
