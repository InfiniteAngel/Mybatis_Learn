package com.mybatis.learn.day01.mappers;

import com.mybatis.learn.day01.pojo.Students;
import com.mybatis.learn.day01.pojo.Tutor;

public interface One2ManyMapper {
    public Tutor findTutorById(int i);

}
