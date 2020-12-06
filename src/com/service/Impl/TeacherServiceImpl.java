package com.service.Impl;

import com.entity.*;
import com.mapper.TeacherMapper;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper tm;

    @Override
    public void sub_Project(Project project) {
        // TODO Auto-generated method stub
        tm.sub_Project(project);
    }

    @Override
    public Project find_Project(Project project) {
       return tm.find_Project(project);

    }


    @Override
    public void sub_Projectmember(Projectmember projectmember) {
        // TODO Auto-generated method stub
        System.out.println("服务层："+projectmember.getProjectId());
         tm.sub_Projectmember(projectmember);
    }



    @Override
    public List<Project> t_Project(Project project) {
        // TODO Auto-generated method stub
        return tm.t_Project(project);
    }

    @Override
    public List<Projectmember> Pass_Detailed(int projectId) {
        return tm.Pass_Detailed(projectId);
    }



    @Override
    public List<Currentyear> currentYear() {
        // TODO Auto-generated method stub
        return tm.currentYear();
    }



    @Override
    public List<Item> item() {
        // TODO Auto-generated method stub
        return tm.item();
    }

    @Override
    public List<Teacher> allteacher() {

        return tm.allteacher();
    }

    @Override
    public Projectmember teacher_score(String teacherId) {
        return tm.teacher_score(teacherId);

    }

    @Override
    public Teacher find_teacher(String tId) {
        return tm.find_teacher(tId);

    }

    @Override
    public String edit_teacher(Teacher teacher) {
        int i = tm.edit_teacher(teacher);

        if (i == 1){
            return "修改成功";
        }else {
            return "修改失败";
        }

    }

    @Override
    public void disable_teacher(String[] tIds) {
        tm.disable_teacher(tIds);
    }

    @Override
    public void find_Projectmember(Projectmember projectmember) {

    }

    @Override
    @Transactional
    public String edit_project(Project project) {
        int i = tm.edit_project(project);
        int line = tm.deleteProjectRefuse(project.getProjectId());
        System.out.println(line);
        System.out.println("here");
        if (i == 1){
            return "修改成功";
        }else {
            return "修改失败";
        }

    }

    @Override
    public List<Currentyear> getProjectYear() {
        return tm.getProjectYear();
    }
}
