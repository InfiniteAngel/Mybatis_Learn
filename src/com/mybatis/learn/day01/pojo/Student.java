package com.mybatis.learn.day01.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Student implements Comparable<Student>{
    private Integer studId;
    private String name;
    private String email;
    private Date dod;
    private PhoneNumber phone;

    public Student() {
    }

    public Student(Integer studId, String name, String email, Date dod) {
        this.studId = studId;
        this.name = name;
        this.email = email;
        this.dod = dod;
    }

    public Student(Integer studId, String name, String email, Date dod, PhoneNumber phone) {
        this.studId = studId;
        this.name = name;
        this.email = email;
        this.dod = dod;
        this.phone = phone;
    }

    @Override
    public int compareTo(Student student) {
        if (studId<student.studId) {
            return -1;
        }
        if (studId>student.studId){
            return 1;
        }
        return 0;
    }
}
