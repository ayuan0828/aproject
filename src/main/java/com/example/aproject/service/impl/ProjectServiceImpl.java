package com.example.aproject.service.impl;

import com.example.aproject.beans.ProjectEntity;

import com.example.aproject.dao.ProjectEntityMapper;
import com.example.aproject.service.IProjectService;
import com.example.aproject.utils.DateUtil;
import com.example.aproject.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 功能：业务逻辑层实现子类
 *          项目信息的添加、修改、删除、查询操作
 *
 *          id,user_id,project_name,project_content,created_by,creation_date,last_updated_by,last_update_date
 */
@Service
public class ProjectServiceImpl  implements IProjectService {

    /**
     * 功能：注入数据库访问层接口的代理子类对象
     */
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    /**
     * 功能：添加项目信息
     * @param projectEntity :项目对象
     * @param user : 添加项目的用户名
     * @return
     */
    @Override
    public int addProjectInfo(ProjectEntity projectEntity, String user) {
        String id = UUIDUtil.getOneUUID();
        projectEntity.setId(id);
        // 设置用户信息
        projectEntity.setCreatedBy(user);
        projectEntity.setLastUpdatedBy(user);
        // 获取当前系统时间
        Date date = DateUtil.getCreateTime();
        projectEntity.setCreationDate(date);
        projectEntity.setLastUpdateDate(date);

        // 调用数据库访问层中的添加方法

        return projectEntityMapper.insertProject(projectEntity);
    }

    /**
     * 功能：根据项目编号修改项目信息
     * @param projectEntity ：要修改的项目对象
     * @param user ：修改的用户
     * @return
     */
    @Override
    public int modifyProjectInfo(ProjectEntity projectEntity, String user) {
        projectEntity.setLastUpdatedBy(user);
        //获取当前系统时间
        Date date = DateUtil.getCreateTime();
        projectEntity.setLastUpdateDate(date);

        // 调用数据库访问层中的修改方法
        return projectEntityMapper.updateProject(projectEntity);
    }

    /**
     * 删除项目
     * @param projectEntity
     * @return
     */
    @Override
    public int deleteProjectById(ProjectEntity projectEntity) {
        // 获取要删除的项目编号
        String projectId = projectEntity.getId();
        // 调用数据库访问层实现数据的删除操作

        return projectEntityMapper.deleteProject(projectId);
    }

    /**
     * 功能：按条件查询项目信息
     * @param projectEntity
     * @return
     */
    @Override
    public List<Object> queryProjectList(ProjectEntity projectEntity) {
        List<Object> resultList = new ArrayList<Object>();
        // 调用数据库访问层实现数据的查询操作
        List<Map<String,Object>> proResult = projectEntityMapper.queryProjectByCondition(projectEntity);
        for(Map<String,Object> proobj : proResult){
            resultList.add(proobj);
        }
        return resultList;
    }

    /**
     * 功能：实现多表之间的联合查询操作
     * @return
     */
    @Override
    public List<Map<String, Object>> queryProject() {
        return projectEntityMapper.queryAllProject();
    }
}
