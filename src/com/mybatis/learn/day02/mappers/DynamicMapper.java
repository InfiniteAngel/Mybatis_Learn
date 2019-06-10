package com.mybatis.learn.day02.mappers;

import com.mybatis.learn.day01.pojo.Course;


import java.util.List;
import java.util.Map;

public interface DynamicMapper {
    List<Course> searchCourses(Map<String ,Object> map);
    List<Course> searchCoursesByTutors(Map<String,Object> map);
}
