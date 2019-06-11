package com.mybatis.learn.day02.test;

import com.mybatis.learn.day01.pojo.Gender;
import com.mybatis.learn.day01.pojo.User;
import com.mybatis.learn.day01.pojo.UserPic;
import com.mybatis.learn.day01.utils.MybatisSqlSessionFactory;
import com.mybatis.learn.day02.mappers.SpecialMapper;
import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test_insertUserPic(){
        byte[] pic = null;
        try {
            //读取用户头像图片
            File file = new File("src/2.jpg");
            InputStream is = new FileInputStream(file);
            pic = new byte[is.available()];//查看有多少字节
            is.read(pic);
            is.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        String name = "tom";
        String bio = "可以是很长的字符串";
        //准备好要插入到数据库中的数据并封装成对象
        UserPic userPic = new UserPic(name, pic , bio);

        SqlSession session = null;
        try{
            session = MybatisSqlSessionFactory.openSession();
            SpecialMapper mapper = session.getMapper(SpecialMapper.class);
            mapper.insertUserPic(userPic);
            session.commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null)session.close();
        }
    }
    @Test
    public void test_getUserPicById(){

        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            SpecialMapper mapper = session.getMapper(SpecialMapper.class);

            UserPic userPic = mapper.getUserPicById(1);

            System.out.println(userPic.getId());
            System.out.println(userPic.getName());
            System.out.println(userPic.getBio());
            System.out.println(userPic.getPic().length);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
    @Test
    public void test_selectUserMaps(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        Map<Integer, User> map = sqlSession.selectMap("com.mybatis.learn.day02.mappers.SpecialMapper.findAllUsers","id");
        for(Integer key:map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }

    }
    @Test
    public void test_findAllUsers(){
        SqlSession session = MybatisSqlSessionFactory.openSession();
        SpecialMapper mapper = session.getMapper(SpecialMapper.class);
        int offset = 0;
        //显示的条目
        int limit = 3;
        RowBounds rowBounds = new RowBounds(offset,limit);
        List<User> users = mapper.findAllUsers(rowBounds);
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void test_ResultHandler(){
        final Map<Integer,String> map = new HashMap<Integer, String>();
        SqlSession session = null;
        try {
            session = MybatisSqlSessionFactory.openSession();

            session.select("com.mybatis.learn.day02.mappers.SpecialMapper.findAllUsers", new ResultHandler<User>() {
                @Override
                public void handleResult(ResultContext<? extends User> resultContext) {
                    User user = resultContext.getResultObject();
                    map.put(user.getId(), user.getName());
                }
            });

            for(Integer key:map.keySet()){
                System.out.println(key+" : "+map.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }

}
