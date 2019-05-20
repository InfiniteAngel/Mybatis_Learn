package com.mybatis.learn.day01.test;

import com.mybatis.learn.day01.mappers.StudentMapper;
import com.mybatis.learn.day01.pojo.Student;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class StudentMapperTest {
    @Test
    public void insertStudentTest(){
        //获取SqlSession对象
        try {
            InputStream inputStream =Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(2,"Ling","Ling@qq.com",new Date());
            mapper.insertStudent(student);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void inserStudentTest2(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession(true);
        Student student = new Student(3,"XiaNa","XiaNa@qq.com",new Date());
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(student);
    }
}
