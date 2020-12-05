package com.service.Impl;
import com.entity.*;
import com.mapper.RootMapper;
import com.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public  class RootServiceImpl implements RootService {
    @Autowired
    RootMapper rm;


    @Override
    public Teacher Login(Teacher teacher) {
        return rm.Login(teacher);
    }

    @Override
    public void Addteacher(Teacher teacher) {
        rm.Addteacher(teacher);

    }

    @Override
    public List<Teacher> Teacher() {
        return rm.Teacher();
    }

    @Override
    public List<Project> Project() {
        return rm.Project();
    }

    @Override
    public List<Project> Pass() {
        return rm.Pass();
    }

    @Override
    public List<Projectmember> getProjectMembers(int projectId) {
        return rm.getProjectMembers(projectId);
    }

    @Override
    public List<Project> Refuse() {
        return rm.Refuse();
    }

    @Override
    public List<Projectrefuse> Refuse_Detailed(int projectId) {
        return rm.Refuse_Detailed(projectId);
    }

    @Override
    public void insert_Pass(Projectmember projectmember) {
        rm.insert_Pass(projectmember);

    }

    @Override
    public void insert_Refuse(Projectrefuse projectrefuse) {
        rm.insert_Refuse(projectrefuse);

    }

    @Override
    public void update_Pass(int projectId) {
        rm.update_Pass(projectId);

    }

    @Override
    public void update_Refuse(int projectId) {
        rm.update_Refuse(projectId);

    }

    @Override
    public void Addad(Teacher teacher) {
        rm.Addteacher(teacher);

    }

    @Override
    public Teacher Find_passwd(Teacher email) {
        return rm.Find_passwd(email);
    }

    @Override
    public void Send(Teacher teacher) {
        rm.Send(teacher);

    }

    @Override
    public Teacher Jurisdiction(Teacher teacher) {
        return rm.Jurisdiction(teacher);
    }

    @Override
    public void update_passwd(Teacher teacher) {
        rm.update_passwd(teacher);

    }

    @Override
    public void Add_year(Currentyear currentyear) {
        rm.Add_year(currentyear);

    }

    @Override
    public void Add_item(Item item) {
        rm.Add_item(item);

    }

    @Override
    public void Stop_item(Item item) {
        rm.Stop_item(item);

    }

    @Override
    public void Used_item(Item item) {
        rm.Used_item(item);

    }

    @Override
    public void Stop_year(Currentyear currentyear) {
        rm.Stop_year(currentyear);

    }

    @Override
    public void Used_year(Currentyear currentyear) {
        rm.Used_year(currentyear);

    }

    @Override
    public List <Projectmember> teacher_score() {
        return rm.teacher_score();
    }

    @Override
    public List <Projectmember> projectYear_score(String projectYear) {
        return rm.projectYear_score(projectYear);
    }

}
