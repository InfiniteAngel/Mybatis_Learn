package com.mybatis.learn.day01.test;

import com.mybatis.learn.day01.mappers.One2ManyMapper;
import com.mybatis.learn.day01.mappers.One2OneMapper;
import com.mybatis.learn.day01.pojo.Students;
import com.mybatis.learn.day01.pojo.Tutor;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class One2ManyMapperTest {
    @Test
    public void test_findTutorById(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        One2ManyMapper mapper = sqlSession.getMapper(One2ManyMapper.class);
        Tutor tutor = mapper.findTutorById(2);
        System.out.println(tutor);

    }
}
