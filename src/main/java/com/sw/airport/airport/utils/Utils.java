package com.sw.airport.airport.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String userEmailValidation(String email) {
        if (email == null || email.isEmpty()){
            throw new RuntimeException("Email cannot be null or empty");
        }
        String mailNickname = email.split("@")[0];
        //@()\[]";:.<>,SPACE
        mailNickname = mailNickname.replaceAll("[^a-zA-Z0-9]", "");
        if (mailNickname.length() > 64){
            mailNickname = mailNickname.substring(0, 64);
        }
        return mailNickname;
    }

    public static  String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
