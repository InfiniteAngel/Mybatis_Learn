package com.mybatis.learn.day02.mappers;

import com.mybatis.learn.day01.pojo.User;
import com.mybatis.learn.day01.pojo.UserPic;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SpecialMapper {
    public void insertUser(User user);

    public void insertUserPic(UserPic userPic);

    public UserPic getUserPicById(int i);
        //分页功能
    public List<User> findAllUsers(RowBounds rowBounds);


}
