package com.mybatis.learn.day01.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Gender gender;

    public User(Integer id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public User(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public User() {
    }
}

