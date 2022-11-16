package com.example.aproject.service;

import com.example.aproject.beans.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 功能：业务逻辑层实现项目信息的增删改查操作
 */
public interface IProjectService {

    /**
     * 功能：添加项目
     * @param projectEntity :项目对象
     * @param user : 添加项目的用户名
     * @return
     */
    public int addProjectInfo(ProjectEntity projectEntity,String user);

    /**
     * 功能：修改项目
     * @param projectEntity ：要修改的项目对象
     * @param user ：修改的用户
     * @return
     */
    public int modifyProjectInfo(ProjectEntity projectEntity,String user);

    /**
     * 功能：根据项目的编号删除项目信息
     * @param projectEntity
     * @return
     */
    public int deleteProjectById(ProjectEntity projectEntity);

    /**
     * 功能：查询项目列表
     *         如果查询条件不为空，则按条件查询
     * @param projectEntity
     * @return
     */
    public List<Object> queryProjectList(ProjectEntity projectEntity);

    /**
     * 功能：实现多表之间联合查询（项目信息以及创建该项目的用户信息）
     * @return
     */
    public List<Map<String,Object>> queryProject();

}
