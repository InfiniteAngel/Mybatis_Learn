package com.mybatis.learn.day01.test;

import com.mybatis.learn.day01.mappers.StudentMapper;
import com.mybatis.learn.day01.pojo.PhoneNumber;
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
import java.util.List;

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
        PhoneNumber phone = new PhoneNumber("110","112","119");
        Student student = new Student(4,"yan","yan@qq.com",new Date(),phone);
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(student);
    }

    @Test
    public void findStudentById(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudentById(4);
        System.out.println(student);
    };

    @Test
    public void findAllStudentsTest(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.findAllStudents();
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public  void updateStudentById(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        mapper.updateStudentById(new Student(3,"yan.angel",null,null));
        sqlSession.commit();
    }
    @Test
    public void deleteStudentById(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudentById(3);
        sqlSession.commit();
    }
    @Test
    public void deleteAllStudents(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        mapper.deleteAllStudents();
        sqlSession.commit();
    }


}
