package com.mybatis.learn.day02.test;

import com.mybatis.learn.day01.pojo.Gender;
import com.mybatis.learn.day01.pojo.User;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import com.mybatis.learn.day02.mappers.SpecialMapper;
import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SpecialMapperTest {
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = null;


        try{
            sqlSession = MybatisSqlSessionFactory.openSession();
            SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
            mapper.insertUser(new User("rose1", Gender.FEMALE));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally{
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
