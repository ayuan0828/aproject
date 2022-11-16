package com.example.aproject.controller;

import com.example.aproject.beans.HttpResponseEntity;
import com.example.aproject.beans.ProjectEntity;
import com.example.aproject.common.Constans;
import com.example.aproject.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前端控制器--实现对项目信息的操作
 */
@RestController
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity responseEntity = new HttpResponseEntity();
        //1.调用业务逻辑层的查询操作
       List<Object> result =  projectService.queryProjectList(projectEntity);

        //2.封装HttpResponseEntity对象(状态码，数据)
        responseEntity.setCode(Constans.SUCCESS_CODE);
        responseEntity.setData(result);
        return  responseEntity;
    }


    @RequestMapping(value="/addProjectInfo" ,method = RequestMethod.POST,headers ="Accept=application/json" )
    public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity responseEntity = new HttpResponseEntity();
        // 1.调用业务逻辑层实现添加操作
        projectService.addProjectInfo(projectEntity,"admin");
        //2. 封装HttpResponseEntity对象（状态码，消息）
        responseEntity.setCode(Constans.SUCCESS_CODE);
        responseEntity.setMessage(Constans.ADD_MESSAGE);
        return responseEntity;
    }


    @RequestMapping(value="/modifyProjectInfo",method =  RequestMethod.POST,headers ="Accept=application/json")
    public HttpResponseEntity updateProjectInfo(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity responseEntity = new HttpResponseEntity();
        //1.调用业务逻辑层实现修改操作
        projectService.modifyProjectInfo(projectEntity,"admin");
        //2.封装HttpResponseEntity对象（状态码，消息）
        responseEntity.setCode(Constans.SUCCESS_CODE);
        responseEntity.setMessage(Constans.UPDATE_MESSAGE);
        return  responseEntity;
    }


    @RequestMapping(value="/deleteProjectById",method = RequestMethod.POST,headers ="Accept=application/json" )
    public HttpResponseEntity deleteProjectInfo(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity responseEntity = new HttpResponseEntity();
        //1.调用业务逻辑层中的删除操作
        projectService.deleteProjectById(projectEntity);
        //2.封装HttpResponseEntity对象(状态码，消息)
        responseEntity.setCode(Constans.SUCCESS_CODE);
        responseEntity.setMessage(Constans.DELETE_MESSAGE);
        return  responseEntity;
    }


}
