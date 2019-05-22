package com.mybatis.learn.day01.pojo;

import lombok.Data;

@Data
public class PhoneNumber {
    private String countryCode;
    private String stateCode;
    private String number;
    public PhoneNumber(){
    }
    //获取从数据库中返回
    //110-119-120
    public PhoneNumber(String phone){
        if (phone!=null) {
            String[] split = phone.split("-");
            countryCode = split[0];
            stateCode = split[1];
            number = split[2];
        }
    }
    public PhoneNumber(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }
    public String getAsString() {
        return countryCode + "-" + stateCode + "-" + number;
    }
}
