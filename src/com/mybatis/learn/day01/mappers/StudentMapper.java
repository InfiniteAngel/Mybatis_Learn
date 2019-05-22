package com.mybatis.learn.day01.mappers;

import com.mybatis.learn.day01.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public void insertStudent( Student student);
    public Student findStudentById(int i);
    public List<Student> findAllStudents();
    public void updateStudentById(Student student);
    public void deleteStudentById(int i);
    public void deleteAllStudents();
}

