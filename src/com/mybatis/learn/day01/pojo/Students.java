package com.mybatis.learn.day01.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Students {
    private Integer studId;
    private String name;
    private String email;
    private Date dob;
    private PhoneNumber phone;
    private Address address;

    public Students() {

    }

    public Students(String name, String email, Date dob, PhoneNumber phone, Address address) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }

    public Students(Integer studId, String name, String email, Date dob, PhoneNumber phone, Address address) {
        this.studId = studId;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }
}
