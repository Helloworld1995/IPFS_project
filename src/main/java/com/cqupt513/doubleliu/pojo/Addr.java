package com.cqupt513.doubleliu.pojo;

public class Addr {
    private Integer id;
    private String address;
    private String idx;
    private String encode;
    private Integer mid;

    public Integer getId() {
        return id;
    }

    public Addr setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMid() {
        return mid;
    }

    public Addr setMid(Integer mid) {
        this.mid = mid;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Addr setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getIdx() {
        return idx;
    }

    public Addr setIdx(String idx) {
        this.idx = idx;
        return this;
    }

    public String getEncode() {
        return encode;
    }

    public Addr setEncode(String encode) {
        this.encode = encode;
        return this;
    }
}
