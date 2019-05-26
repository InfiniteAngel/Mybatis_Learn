package com.mybatis.learn.day01.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Tutor {
    private Integer tutorId;
    private String name;
    private String email;
    private PhoneNumber phone;
    private Address address;
    private List<Course> courses;

    public Tutor() {
    }

    public Tutor(Integer tutorId, String name, String email, PhoneNumber phone, Address address, List<Course> courses) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.courses = courses;
    }
//00:44
}
