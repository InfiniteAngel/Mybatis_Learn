package com.mybatis.learn.day01.mappers;

import com.mybatis.learn.day01.many2many.Course;
import com.mybatis.learn.day01.many2many.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Many2ManyMapper {

    public<T> T getMapperTest(Class<T> clazz);
    public<T> T selectOne(String str);
    //插入student数据
    public void insertStudent(Student student);
    //插入course数据
    public void insertCourse(Course course);
    //通过id查询学生
    public Student getStudentById(Integer id);
    //通过id查询课程
    public Course getCourseById(Integer id);

    //学生x选课y
    public void studentSelectCourse(@Param("ss")Student student, @Param("cc")Course course);

    //查询比指定id值小的学生信息
    public List<Student> getStudentByIdOnCondition(Integer id);
    //查询student级联查询出所选的course并且组装成完整的对象
    public Student getStudentByIdWithCourses(Integer id);
}
