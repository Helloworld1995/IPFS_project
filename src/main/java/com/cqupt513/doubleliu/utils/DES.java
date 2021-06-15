package com.cqupt513.doubleliu.utils;


import org.springframework.stereotype.Component;

@Component
public class DES {
    public String encode(String src,String key){
        int j=0;
        char[] cs = src.toCharArray();
        int len=key.length();
        for (int i = 0; i < cs.length ; i++) {
            cs[i]= (char) (cs[i]+(int)key.charAt(j%len));
            j++;
        }
        return new String(cs);
    }
    public String decode(String dst,String key){
        int j=0;
        char[] cs = dst.toCharArray();
        int len=key.length();
        for (int i = 0; i < cs.length ; i++) {
            cs[i]= (char) (cs[i]-(int)key.charAt(j%len));
            j++;
        }
        return new String(cs);
    }
//    public static void main(String[] args) {
//        DES des=new DES();
//        String s1=des.encode("hahahahahahahhahahahahaha","132324faf3a");
//        String s2=des.decode(s1,"132324faf3a");
//        System.out.println(s1);
//        System.out.println(s2);
//    }
}
