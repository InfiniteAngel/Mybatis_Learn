package com.mybatis.learn.day02.test;

import com.mybatis.learn.day01.pojo.Course;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import com.mybatis.learn.day02.mappers.DynamicMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class DynamicMapperTest {
    @Test
    public void searchCourses(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("tutorId", 2);
        //map.put("searchBy","Tutor");
        map.put("courseName", "%Java%");
        //map.put("startDate", new Date());
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        List<Course> courses = mapper.searchCourses(map);
        for (Course course : courses){
            System.out.println(course);
        }
    }
    @Test
    public void searchCoursesByTutors(){
        SqlSession sqlSession =MybatisSqlSessionFactory.openSession();
        Map<String,Object> map = new HashMap<String,Object>();
        List<Integer> tutorIds = new ArrayList<Integer>();
        tutorIds.add(1);
        tutorIds.add(2);
        tutorIds.add(3);
        map.put("tutorIds", tutorIds);
        DynamicMapper mapper =
                sqlSession.getMapper(DynamicMapper.class);
        List<Course> courses = mapper.searchCoursesByTutors(map);
        for (Course course : courses){
            System.out.println(course);
        }
    }
}
