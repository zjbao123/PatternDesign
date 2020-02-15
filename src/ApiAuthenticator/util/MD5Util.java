package com.Pattern.design.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String md5(String  plainText){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("MD5");

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new RuntimeException("No such AlgorithException!");
        }
        md.update(plainText.getBytes());
        return new BigInteger(1, md.digest()).toString(16);

    }
}
