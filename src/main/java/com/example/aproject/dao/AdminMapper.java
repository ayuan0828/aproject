package com.example.aproject.dao;


import com.example.aproject.beans.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    public Admin findAdminByName(String username);
    /**通过账号和密码查询管理员**/
    public Admin findAdmin(Admin admin);
    public int addAdmin(Admin admin);    //添加管理员信息
    public int deleteAdmin(Integer id);   //删除管理员信息
    public int updateAdmin(Admin admin); //修改管理员信息
    public Admin findAdminById(Integer id);
    public List<Admin> getAll();
}
