package com.mybatis.learn.day01.test;

import com.mybatis.learn.day01.mappers.One2OneMapper;
import com.mybatis.learn.day01.pojo.Students;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class One2oneMapperTest {
    @Test
    public void test_findStudentWithAddress(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        One2OneMapper mapper = sqlSession.getMapper(One2OneMapper.class);
        Students studens= mapper.findStudentWithAddress(2);
        System.out.println(studens);
    }
}
