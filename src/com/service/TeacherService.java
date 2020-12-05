package com.service;

import com.entity.*;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List <Project> t_Project(Project project);
    List <Projectmember> Pass_Detailed(int projectId);
    void sub_Project(Project project);
    Project find_Project(Project project);
    void sub_Projectmember(Projectmember projectmember);
    List <Currentyear> currentYear();
    List <Item> item();
    List <Teacher> allteacher();
    Projectmember teacher_score(String teacherId);

    Teacher find_teacher(String tId);
    String edit_teacher(Teacher teacher);

    void disable_teacher(String[] tIds);

    void find_Projectmember(Projectmember projectmember);

    String edit_project(Project project);

    List<Currentyear> getProjectYear();
    // Teacher teacher_info(String teacherId);
}
