package com.cqupt513.doubleliu.pojo;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private boolean isUpload;
    private String hashcode;
    private Date date;
    private String verifycode;

    public Integer getId() {
        return id;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public User setVerifycode(String verifycode) {
        this.verifycode = verifycode;
        return this;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isUpload() {
        return isUpload;
    }

    public User setUpload(boolean upload) {
        isUpload = upload;
        return this;
    }

    public String getHashcode() {
        return hashcode;
    }

    public User setHashcode(String hashcode) {
        this.hashcode = hashcode;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public User setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isUpload=" + isUpload +
                ", hashcode='" + hashcode + '\'' +
                ", date=" + date +
                ", verifycode='" + verifycode + '\'' +
                '}';
    }
}
