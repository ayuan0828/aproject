package com.example.aproject.service;

import com.example.aproject.beans.Admin;

import java.util.List;

public interface AdminService {
    public Admin findAdminByName(String username);
    // 通过账号和密码查询用户
    public Admin findAdmin(Admin admin);

    public int addAdmin(Admin admin);    //添加管理员信息
    public int deleteAdmin(Integer id);   //删除管理员信息
    public int updateAdmin(Admin admin); //修改管理员信息
    public Admin findAdminById(Integer id);
    //找到所有所有数据
    public List<Admin> getAll();
}
