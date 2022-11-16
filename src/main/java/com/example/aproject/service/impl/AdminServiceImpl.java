package com.example.aproject.service.impl;

import com.example.aproject.beans.Admin;
import com.example.aproject.dao.AdminMapper;
import com.example.aproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    /**
     * 功能：注入数据库访问层对象
     */
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByName(String username) {
        return adminMapper.findAdminByName(username);
    }

    @Override
    public Admin findAdmin(Admin admin) {
        Admin a = adminMapper.findAdmin(admin);
        return a;
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin findAdminById(Integer id) {
        Admin a = adminMapper.findAdminById(id);
        return  a;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> adminList = adminMapper.getAll();
        return adminList;
    }
}
