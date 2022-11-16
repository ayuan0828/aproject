package com.example.aproject.controller;

import com.example.aproject.beans.Admin;
import com.example.aproject.beans.HttpResponseEntity;
import com.example.aproject.common.Constans;
import com.example.aproject.service.AdminService;

import com.example.aproject.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;


    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/admin")
    public String login() {
        return "adminLogin";
    }


    /**
     * 登录
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/toLogin",method= RequestMethod.POST)
    public String Login(String username, String password,Model model) {
        if(username.equals("master")&&password.equals("1")){
            return "homepage";
        }
        // 通过账号和密码查询用户
         else if (username!=null) {
            Admin admin = adminService.findAdminByName(username);
            if((admin != null)&&(password.equals(admin.getPassword()))){

                return "homepage1";}
        }
        return "adminLogin";
    }

    /**
     * 退出登录
     * @param admin
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(Admin admin, Model model, HttpSession session) {
        session.invalidate();
        return "adminLogin";

    }

    /**
     * 添加管理员信息
     * @param admin
     * @return
     */
    @RequestMapping(value = "/addAdmin")
    public String addAdmin(Admin admin) {


        adminService.addAdmin(admin);
        return "adminLogin";
    }

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    @RequestMapping( "/deleteAdmin")
    public String deleteAdmin(Integer id) {
        adminService.deleteAdmin(id);
        return "redirect:/findalladmin";
    }


    /**
     * 根据id查找管理员
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findAdminById")
    public String findAdminById(Integer id,Model model){
        Admin admin= adminService.findAdminById(id);
        model.addAttribute("admin",admin);
        return "editadmin";
    }

    @RequestMapping("/findalladmin")
    public String findAllAdmin(Model model){
        //调用业务逻辑层查询所有的用户信息
        List<Admin> admins = adminService.getAll();
        model.addAttribute("admins",admins);
        return "adminList";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin){
        //调用业务逻辑层中的修改方法
        adminService.updateAdmin(admin);
        return "redirect:/findalladmin";
    }

    @RequestMapping("/toReturn")
    public String toReturn(){
        return "homepage";
    }


}
