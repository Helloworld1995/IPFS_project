package com.cqupt513.doubleliu.pojo;

public class Key {
    private String hash;
    private String sykey;
    private String address;

    public String getAddress() {
        return address;
    }

    public Key setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public Key setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getSykey() {
        return sykey;
    }

    public Key setSykey(String sykey) {
        this.sykey = sykey;
        return this;
    }
}
