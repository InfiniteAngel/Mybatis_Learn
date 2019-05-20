package com.mybatis.learn.day01.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer studId;
    private String name;
    private String email;
    private Date dob;

    public Student() {
    }

    public Student(Integer studId, String name, String email, Date dob) {
        this.studId = studId;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}
