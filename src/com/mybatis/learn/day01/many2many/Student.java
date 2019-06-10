package com.mybatis.learn.day01.many2many;

import lombok.Data;

import java.util.List;
@Data
public class Student {
    private Integer id;
    private String name; // 姓名
    private String gender; // 性别
    private String major; // 专业
    private String grade; // 年级
    private List<Course> courses;// 所选的课程

    public Student(String name, String gender, String major, String grade) {
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
    }

    public Student(Integer id, String name, String gender, String major, String grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
    }

    public Student() {
    }

    public Student(Integer id, String name, String gender, String major, String grade, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
        this.courses = courses;
    }
}
