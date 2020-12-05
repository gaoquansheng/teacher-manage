package com.controller;

import java.net.URLDecoder;
import java.text.ParseException;
import java.util.*;

import com.entity.*;
import com.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import static sun.plugin.javascript.navig.JSType.URL;


@Controller
@RequestMapping("root")
public class RootController {
    @Autowired
    private RootService rs;
    @RequestMapping("/html/{where}")
    public String tiaozhuan(@PathVariable String where) {
        System.out.println("地址为："+where);
        return where;
    }


    @ResponseBody
    @RequestMapping("/Login")
    public String Login(@RequestBody Teacher teacher, HttpSession session){
        Teacher th=rs.Login(teacher);
        return JSON.toJSONString(th).toString();
    }

    @ResponseBody
    @RequestMapping("/Addteacher")
    public void Addtteacher(@RequestBody Teacher teacher){
        rs.Addteacher(teacher);
    }

    @ResponseBody
    @RequestMapping("/teacherList")
    public void addTeacherList(@RequestBody List<Teacher> teachers){
        for(Teacher t: teachers){
            rs.Addteacher(t);
        }

    }

    @ResponseBody
    @RequestMapping("/Teacher")
    public String Teacher(){
        List <Teacher> t=rs.Teacher();
        return JSON.toJSONString(t);
    }

    @ResponseBody
    @RequestMapping("/Project")
    public String Project(){
        List <Project> pj=rs.Project();
        return JSON.toJSONString(pj).toString();
    }

    @ResponseBody
    @RequestMapping("/Pass")
    public String Pass(){
        List <Project> pass=rs.Pass();
        return JSON.toJSONString(pass).toString();

    }


    @ResponseBody
    @RequestMapping("/projectMember")
    public String getProjectMembers(@RequestBody Projectmember projectmember){
        int projectId=projectmember.getProjectId();

        List <Projectmember> member=rs.getProjectMembers(projectId);
        return JSON.toJSONString(member);
    }


    @ResponseBody
    @RequestMapping("/Refuse")
    public String Refuse(){
        List<Project> refuse=rs.Refuse();
        return JSON.toJSONString(refuse);
    }


    @ResponseBody
    @RequestMapping("/Refuse_Detailed")
    public String Refuse_Detailed(@RequestBody Projectrefuse projectrefuse){
        int projectId=projectrefuse.getProjectId();
        List<Projectrefuse> refuse=rs.Refuse_Detailed(projectId);
        return JSON.toJSONString(refuse).toString();
    }


    @ResponseBody
    @RequestMapping("/Insert_Pass")
    public void update_Pass(@RequestBody Project project,Projectmember projectmember){
        Nowtime nn=new Nowtime();
        Date time=null;
        try {
             time=nn.Time();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int projectId=project.getProjectId();
        int scoreall=project.getScore();
        List<Projectmember> list=rs.getProjectMembers(projectId);
        int numbre=list.size();
        System.out.println(numbre+"length");
        float sum=0;
        for (int i=0;i<list.size();i++){
          float   w=list.get(i).getWeight();
          sum=sum+w;
        }
        for (int i=0;i<list.size();i++){
            String teacherId=list.get(i).getTeacherId();
            String tName=list.get(i).gettName();
            float weight=list.get(i).getWeight();
            float score=0;
            if(weight==0){
                 score = (1-sum)*scoreall;
            }else{
                 score=weight*scoreall;
            }
            projectmember.setTeacherId(teacherId);
            projectmember.settName(tName);
            projectmember.setWeight(weight);
            projectmember.setCreateTime(time);
            projectmember.setScore(score);
            projectmember.setProjectId(projectId);
            rs.insert_Pass(projectmember);
        }
           rs.update_Pass(projectId);
    }



    @ResponseBody
    @RequestMapping("/Insert_Refuse")
    public void insert_Refuser(@RequestBody Project project,Projectrefuse projectrefuse)throws ParseException{
        Nowtime nn=new Nowtime();
        Date time=nn.Time();
        int projectId=project.getProjectId();
        String reason=project.getReason();
        String submitter=project.getSubmitter();
        String name=project.getName();
        projectrefuse.setCreateTime(time);
        projectrefuse.setProjectId(projectId);
        projectrefuse.setSubmitter(submitter);
        projectrefuse.setReason(reason);
        projectrefuse.setName(name);
        rs.insert_Refuse(projectrefuse);

        rs.update_Refuse(projectId);
    }


    @ResponseBody
    @RequestMapping("/Addad")
    public void addad(@RequestBody Teacher teacher){
        rs.Addad(teacher);
    }


    @ResponseBody
    @RequestMapping("/Find_passwd")
    public String find_passwd( @RequestBody Teacher email){
        Teacher T=rs.Find_passwd(email);
        String t_email=T.getEmail();
        sendEmail nn=new sendEmail();
        String authCode=nn.achieveCode();
        if(T==null){
            return "";
        }else{
            nn.sendAuthCodeEmail(t_email, authCode);
        }
        return authCode;
    }


    @ResponseBody
    @RequestMapping("/Send_passwd")
    public void send_passwd(@RequestBody Teacher teacher){
        sendEmail nn=new sendEmail();
        String email=teacher.getEmail();
        String authCode=nn.achieveCode();
        teacher.setNew_passwd(authCode);
        teacher.setNewpasswd(authCode);
        rs.Send(teacher);
        nn.new_pwdEmail(email, authCode);
    }


    @ResponseBody
    @RequestMapping("/Jurisdiction")
    public String  jurisdiction(@RequestBody Teacher teacher){

         rs.Jurisdiction(teacher);
         String  administrators= String.valueOf(teacher.getAdministrators());
        return administrators;
    }

    @ResponseBody
    @RequestMapping("/update_Passwd")
    public String update_passwd(@RequestBody Teacher teacher){
        String newpwd=teacher.getPasswd();
        Teacher t=rs.Login(teacher);
        String pwd=t.getPasswd();
        if(newpwd.equals(pwd)){
            rs.update_passwd(teacher);
            return "密码修改成功";
        }else{
            return "原密码错误";
        }
    }

    @ResponseBody
    @RequestMapping("/add_Year")
    public void add_year (@RequestBody Currentyear currentyear)throws ParseException {
        Nowtime nn= new Nowtime();
        Date time=nn.Time();
        currentyear.setStartTime(time);
        rs.Add_year(currentyear);

    }

    @ResponseBody
    @RequestMapping("/add_Item")
    public void add_item(@RequestBody Item item)throws ParseException{
        Nowtime nn=new Nowtime();
        Date time=nn.Time();
        item.setCreateTime(time);
        rs.Add_item(item);

    }

    @ResponseBody
    @RequestMapping("/stop_Item")
    public void stop_item(@RequestBody Item item){
        rs.Stop_item(item);
    }

    @ResponseBody
    @RequestMapping("/used_Item")
    public void used_item(@RequestBody Item item){
        rs.Used_item(item);
    }


    @ResponseBody
    @RequestMapping("/stop_Year")
    public void stop_year(@RequestBody Currentyear currentyear){
        rs.Stop_year(currentyear);

    }

    @ResponseBody
    @RequestMapping("/used_Year")
    public void used_year(@RequestBody Currentyear currentyear){
        rs.Used_year(currentyear);
    }

    @ResponseBody
    @RequestMapping("/teacher_score")
    public String teacher_score(){
        List <Projectmember> list=rs.teacher_score();
        return JSON.toJSONString(list).toString();
    }

    @ResponseBody
    @RequestMapping("/projectYear_score")
    public String projectYear_score(HttpServletRequest request){
        String query = request.getQueryString();
        //queryString传参中文解码
        String projectYear = URLDecoder.decode(query).split("&")[0].split("=")[1];
        System.out.println(projectYear);
        List <Projectmember> list=rs.projectYear_score(projectYear);
        return JSON.toJSONString(list).toString();
    }
}
