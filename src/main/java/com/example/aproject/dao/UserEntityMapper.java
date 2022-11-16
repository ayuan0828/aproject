package com.example.aproject.dao;

import com.example.aproject.beans.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 功能：数据库访问层实现对用户的操作
 * @Repository:
 *      表示数据库访问层的注解
 * @Service
 *      表示业务逻辑层的注解
 */
@Repository
public interface UserEntityMapper {

    /**
     * 功能：验证登录用户的有效性
     * @param username
     * @return 根据用户名查询用户对象（用户名在数据表字段是唯一索引）
     */
    public UserEntity findUserByName(String username);
}
