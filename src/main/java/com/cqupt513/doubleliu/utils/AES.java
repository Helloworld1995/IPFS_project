package com.cqupt513.doubleliu.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Random;

@Component
public class AES {
    public static void main(String[] args) {
        StringBuffer s=new StringBuffer();
        char[] c={'a','b','c','d','e','f','g','h','1','2','3','4','5'};
        int len=c.length;
        Random rand=new Random();
        for (int i = 0; i <4000 ; i++) {
            s.append(c[rand.nextInt(len-1)]);
        }
//        System.out.println(s);
        AES.jdkAES(s.toString());
    }

    public static void jdkAES(String s){
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //设置密钥长度
            keyGenerator.init(128);
            //生成密钥对象
            SecretKey secretKey = keyGenerator.generateKey();
            //获取密钥
            byte[] keyBytes = secretKey.getEncoded();
            //key转换
            Key key = new SecretKeySpec(keyBytes,"AES");

            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            //初始化，设置为加密
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(s.getBytes());
            System.out.println("jdk aes encrypt: " + Base64.encodeBase64String(result));


            //初始化,设置为解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
//            System.out.println("jdk aes desrypt:" + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}