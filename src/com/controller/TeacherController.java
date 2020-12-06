package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.*;
import com.service.TeacherService;
//import com.sun.javafx.scene.web.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService ts;

    @ResponseBody
    @RequestMapping("/T_project")
    public String t_project(@RequestBody Project project){

        List<Project> p=ts.t_Project(project);
        return JSON.toJSONString(p);
    }


    @ResponseBody
    @RequestMapping("/T_projectmember")
    public String p_member(@RequestBody Projectmember projectmember){
        int projectId=projectmember.getProjectId();
        List<Projectmember> member=ts.Pass_Detailed(projectId);
        return JSON.toJSONString(member);
    }


    @ResponseBody
    @RequestMapping("/find_Project")
    public String find_project(@RequestBody Project project){

       Project project1=ts.find_Project(project);
        return JSON.toJSONString(project1);

    }
    @ResponseBody
    @RequestMapping("/edit_Project")
    public String edit_Project(@RequestBody Project project){

       return ts.edit_project(project);


    }
    @ResponseBody
    @RequestMapping("/Sub_Project")
    @Transactional
    public int sub_project(@RequestBody Project project,Projectmember projectmember){
        Nowtime nn=new Nowtime();
        Date time= null;
        try {
            time = nn.Time();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        project.setCreateTime(time);
        ts.sub_Project(project);

        String tid=project.gettId();
        int projectId=project.getProjectId();

        projectmember.setProjectId(projectId);
        projectmember.setTeacherId(tid);
        projectmember.setCreateTime(new Date());
        projectmember.setExplain(project.getJobDescription());
        projectmember.setWeight(1);
        projectmember.setCreator(project.gettId());
        ts.sub_Projectmember(projectmember);

        return project.getProjectId();
    }

    @ResponseBody
    @RequestMapping("/Sub_Projectmember")
    public void sub_Projectmember(@RequestBody List<Projectmember> projectmember){
        System.out.println("here-------------");
        for(int i=0;i<projectmember.size();i++){
            System.out.println(projectmember.get(i).getExplain()+"teacherId");
            ts.sub_Projectmember(projectmember.get(i));
        }


    }


    @ResponseBody
    @RequestMapping("/currentYear")
    public String currentYear(){
        List <Currentyear> c=ts.currentYear();
        return JSON.toJSONString(c).toString();

    }

    @ResponseBody
    @RequestMapping("/item")
    public String item(){
        List<Item> i=ts.item();
        return JSON.toJSONString(i).toString();
    }


    @ResponseBody
    @RequestMapping("/allteacher")
    public String allTeacher(){
        List<Teacher> me=ts.allteacher();
        return JSON.toJSONString(me);
    }
//jksdjfkls
    @ResponseBody
    @RequestMapping("/teacher_score")
    public String teacher_score(@RequestBody Teacher teacher){
        String teacherId=teacher.gettId();
        System.out.println(teacherId);
       return JSON.toJSONString(ts.teacher_score(teacherId)).toString();
    }

    @ResponseBody
    @RequestMapping("/find_teacher")
    public String find_teacher(@RequestBody Teacher teacher){
        Teacher teacher1 = ts.find_teacher(teacher.gettId());
        System.out.println(teacher1);
        return JSON.toJSONString(teacher1);

    }

    @ResponseBody
    @RequestMapping("/edit_teacher")
    public String edit_teacher(@RequestBody Teacher teacher){
        return ts.edit_teacher(teacher);

    }

    @ResponseBody
    @RequestMapping("/disable_teacher")
    public String disable_teacher(@RequestBody String[] tIds){
        ts.disable_teacher(tIds);
        return "hello";

    }

    @ResponseBody
    @RequestMapping("/projectYear")
    public String getProjectYear(){
        List<Currentyear> currentyearList = ts.getProjectYear();
        return JSON.toJSONString(currentyearList);
    }

}
