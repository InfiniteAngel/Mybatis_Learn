package com.mybatis.learn.day01.test;

import com.mybatis.learn.day01.many2many.Course;
import com.mybatis.learn.day01.many2many.Student;
import com.mybatis.learn.day01.mappers.Many2ManyMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;

import java.util.List;

public class Many2Many {
    @Test
    public void test_insertStudent(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

            mapper.insertStudent(new Student("张三","男","计算机","大四"));

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null)session.close();
        }

    }

    @Test
    public void test_insertCourse(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

            mapper.insertCourse(new Course("001","corejava"));
            mapper.insertCourse(new Course("002","oracle"));

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null)session.close();
        }

    }

    @Test
    public void test_studentById(){
        SqlSession session = null;
        try{
            session = MybatisSqlSessionFactory.openSession();
            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
            Student student = mapper.getStudentById(1);
            System.out.println(student);

        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            if (session!=null) {
                session.close();
            }
        }
    }
    @Test
    public void test_courseById(){
        SqlSession session = null;
        try{
            session = MybatisSqlSessionFactory.openSession();
            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
            Course course = mapper.getCourseById(1);
            System.out.println(course);

        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    @Test
    public void test_studentSelectCourse(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

            Student student = mapper.getStudentById(1);
            Course course = mapper.getCourseById(1);

            mapper.studentSelectCourse(student, course);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null)session.close();
        }

    }

    @Test
    public void test_getStudentByIdOnCondition(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

            List<Student> list = mapper.getStudentByIdOnCondition(2);

            for(Student s:list){
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }

    }

    @Test
    public void test_getStudentByIdWithCourses(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);

            Student student = mapper.getStudentByIdWithCourses(1);

            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }

    }

}
