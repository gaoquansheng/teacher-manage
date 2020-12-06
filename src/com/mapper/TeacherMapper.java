package com.mapper;
import java.util.List;
import java.util.Map;

import com.entity.*;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    List <Project> t_Project(Project project);
    List <Projectmember> Pass_Detailed(int projectId);
    void sub_Project(Project project);
    void sub_Projectmember(Projectmember projectmember);
    List <Currentyear> currentYear();
    List <Item> item();
    List <Teacher> allteacher();
    Projectmember teacher_score(String teacherId);

    int edit_teacher(Teacher teacher);
    Teacher find_teacher(String tId);

    void disable_teacher(String[] tIds);

    Project find_Project(Project project);
    int edit_project(Project project);
    List<Currentyear> getProjectYear();

    int deleteProjectRefuse(int projectId);

    void addProjectMembers(@Param("projectmembers") List<Projectmember> projectmembers, @Param("projectId") int projectId);
    void deleteProjectMembers(int projectId);
}
