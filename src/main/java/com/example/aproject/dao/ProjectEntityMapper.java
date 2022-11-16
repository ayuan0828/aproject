package com.example.aproject.dao;

import com.example.aproject.beans.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 功能：数据库访问层实现对项目信息的增删改查操作
 */
@Repository
public interface ProjectEntityMapper {

    /**
     * 功能：添加项目信息
     * @param projectEntity
     * @return
     */
    public int insertProject(ProjectEntity projectEntity);

    /**
     * 功能：修改项目信息
     * @param projectEntity
     * @return
     */
    public int updateProject(ProjectEntity projectEntity);

    /**
     * 功能：实现删除操作
     * @param projectId
     * @return
     */
    public int deleteProject(String projectId);

    /**
     * 功能：1.实现按条件查询
     *      2.如果projectEntity对象的所有属性值为空，则查询全部
     * @param projectEntity
     * @return
     */
    public List<Map<String,Object>> queryProjectByCondition(ProjectEntity projectEntity);

    /**
     * 功能：查询项目全部信息
     * @return
     */
    public List<Map<String,Object>> queryAllProject();
}
