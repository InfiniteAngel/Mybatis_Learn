package com.mybatis.learn.day01.pojo;

import lombok.Data;

//BLOB/CLOB
@Data
public class UserPic {
    private int id;
    private String name;
    private byte[] pic;
    private String bio;

    public UserPic(String name, byte[] pic, String bio) {
        this.name = name;
        this.pic = pic;
        this.bio = bio;
    }

    public UserPic() {

    }


    public UserPic(int id, String name, byte[] pic, String bio) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.bio = bio;
    }
}
