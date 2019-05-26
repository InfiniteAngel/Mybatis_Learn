package com.mybatis.learn.day01.pojo;



import lombok.Data;

import java.util.Date;

@Data
public class Course {
    private Integer courseId;

    public Course() {
    }

    public Course(Integer courseId, String name, String description, Date startDate, Date endDate) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
}
