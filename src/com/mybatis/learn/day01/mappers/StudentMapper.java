package com.mybatis.learn.day01.mappers;

import com.mybatis.learn.day01.pojo.Student;
import com.mybatis.learn.day01.pojo.Students;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface StudentMapper {
    public void insertStudent( Student student);
    public Student findStudentById(int i);
    public List<Student> findAllStudents();
    public Set<Student> findAllStudents_Set();
    public Map<String,Object> findStudentById_Map(int i);
    public  List<Map<String,Object>> findAllStudents_Map();
    public SortedSet<Student> findAllStudents_SortedSet();
    public void updateStudentById(Student student);
    public void deleteStudentById(int i);
    public void deleteAllStudents();

    public Students selectStudentWithAddress(int i);
}

