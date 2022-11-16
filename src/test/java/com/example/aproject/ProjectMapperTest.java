package com.example.aproject;

import com.example.aproject.beans.ProjectEntity;
import com.example.aproject.service.IProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {

    @Autowired
    private IProjectService projectService;

    /**
     * insert into project_info (id,user_id,project_name,project_content,created_by,creation_date,last_updated_by,last_update_date)
     * values ('1001','1','springboot案例','study','admin',now(),'admin',now())
     */
    @Test
    public void testMethod1(){
        //创建添加项目的测试用例
        ProjectEntity projectEntity= new ProjectEntity();
        projectEntity.setUserId("1");
        projectEntity.setProjectName("question project");
        projectEntity.setProjectContent("ok");

        //调用业务逻辑层中的添加方法
        int result = projectService.addProjectInfo(projectEntity,"admin");
        if(result >0){
            System.out.println("success");
        }else{
            System.out.println("failure");
        }
    }

    /**
     * 功能：单元测试项目修改操作
     */
    @Test
    public void testMethod2(){
        // 创建修改项目测试用例
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("4cd6ccb65c894eafaa70b12330f8c2f8");
        projectEntity.setProjectName("第二个项目");
        projectEntity.setProjectContent("项目尚未开工");

        // 调用业务逻辑层中的修改方法
        int flag = projectService.modifyProjectInfo(projectEntity,"xiaoming");
        if(flag >0){
            System.out.println("success");
        }else{
            System.out.println("failure");
        }
    }

    /**
     * 功能：单元测试删除操作
     */
    @Test
    public void testMethod3(){
        //1.测试用例
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("1001");
        //2.调用业务逻辑层中的删除操作
        int flag = projectService.deleteProjectById(projectEntity);
        if(flag >0){
            System.out.println("success");
        }else{
            System.out.println("failure");
        }
    }

    /**
     * 功能:单元测试按条件查询或查询全部
     */
    @Test
    public void testMethod4(){
        //1.查询全部
        List<Object> result = projectService.queryProjectList(null);
        for(Object obj : result){
            Map items = (Map)obj;
            Set<Map.Entry> entryItem =  items.entrySet();
            Iterator<Map.Entry> it = entryItem.iterator();
            while(it.hasNext()){
                Map.Entry entryObj = it.next();
                System.out.println(entryObj.getKey() + "," + entryObj.getValue() +"---");
            }
            System.out.println("-------");
        }
    }

    /**
     * 功能:单元测试按条件查询项目信息
     */
    @Test
    public void testMethod5(){
        //按条件查询
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("项目");
        List<Object> result = projectService.queryProjectList(projectEntity);
        for(Object obj : result){
            Map items = (Map)obj;
            Set<Map.Entry> entryItem =  items.entrySet();
            Iterator<Map.Entry> it = entryItem.iterator();
            while(it.hasNext()){
                Map.Entry entryObj = it.next();
                System.out.println(entryObj.getKey() + "," + entryObj.getValue() +"---");
            }
            System.out.println("-------");
        }
    }

    /**
     * 功能:单元测试按条件查询项目信息
     */
    @Test
    public void testMethod6(){

        List<Map<String,Object>> result = projectService.queryProject();
        for(Map items : result){

            Set<Map.Entry> entryItem =  items.entrySet();
            Iterator<Map.Entry> it = entryItem.iterator();
            while(it.hasNext()){
                Map.Entry entryObj = it.next();
                System.out.println(entryObj.getKey() + "," + entryObj.getValue() +"---");
            }
            System.out.println("-------");
        }
    }
}
