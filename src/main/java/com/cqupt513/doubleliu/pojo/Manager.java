package com.cqupt513.doubleliu.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Manager implements Serializable {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String fname;
    private String hash;
    private Date date;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public Manager setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Manager setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getName() {
        return name;
    }

    public Manager setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Manager setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Manager setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Manager setEmail(String email) {
        this.email = email;
        return this;
    }

    public Manager setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public String getFname() {
        return fname;
    }

    public Manager setFname(String fname) {
        this.fname = fname;
        return this;
    }
}
