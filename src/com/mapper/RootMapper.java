package com.mapper;

import com.entity.*;

import java.util.List;

public interface RootMapper {
    Teacher Login(Teacher teacher);
    void Addteacher(Teacher teacher);
    List<Teacher> Teacher();
    List <Project> Project();
    List <Project> Pass();
    List <Projectmember>getProjectMembers(int projectId);
    List <Project> Refuse();
    List <Projectrefuse> Refuse_Detailed(int projectId);
    void insert_Pass(Projectmember projectmember);
    void insert_Refuse(Projectrefuse projectrefuse);
    void update_Pass(int projectId);
    void update_Refuse(int projectId);
    void Addad(Teacher teacher);
    Teacher Find_passwd(Teacher email);
    void Send(Teacher teacher);
    Teacher Jurisdiction(Teacher teacher);
    void update_passwd(Teacher teacher);
    void Add_year(Currentyear currentyear);
    void Add_item(Item item);
    void Stop_item(Item item);
    void Used_item(Item item);
    void Stop_year(Currentyear currentyear);
    void Used_year(Currentyear currentyear);
    List <Projectmember> teacher_score();
    List <Projectmember> projectYear_score(String projectYear);

    Teacher isEnabled(Teacher teacher);
}
