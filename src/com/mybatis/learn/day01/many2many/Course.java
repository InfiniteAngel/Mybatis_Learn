package com.mybatis.learn.day01.many2many;

import lombok.Data;

import java.util.List;
@Data
public class Course {
    private Integer id;
    private String courseCode; // 课程编号
    private String courseName;// 课程名称
    private List<Student> students;// 选课学生
    public Course() {
    }

    public Course(Integer id, String courseCode, String courseName) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Course(Integer id, String courseCode, String courseName, List<Student> students) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.students = students;
    }


}
