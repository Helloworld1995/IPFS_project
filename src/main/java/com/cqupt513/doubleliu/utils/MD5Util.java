package com.cqupt513.doubleliu.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    private static final String salt="1a2b3c4d";
    public String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    public String inputPassToFromPass(String inputPass){
        String str=salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public String fromPassToDBPass(String formPass){
        String str=salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public String inputPassToDBPass(String inputPass){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass);
        return dbPass;
    }
}
