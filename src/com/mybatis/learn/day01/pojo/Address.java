package com.mybatis.learn.day01.pojo;

import lombok.Data;

@Data
public class Address {
    private Integer addrId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {

    }

    public Address(String street, String city, String state, String zip, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Address(Integer addrId, String street, String city, String state, String zip, String country) {
        this.addrId = addrId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
