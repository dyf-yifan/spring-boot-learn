package com.soft1851.springboot.jwt.test;

import java.security.MessageDigest;
import java.util.UUID;

public class SaltUtil {

    public static void main(String[] args){
        String mySecret = SaltUtil.createSalt();
        System.out.println("当前密钥为："+ mySecret);
    }
    public static String md5(String arg) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(arg.getBytes());
            return byteToHex(bs);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 生成32位的随机盐值
     */
    public static String createSalt(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static String byteToHex(byte[] bytes) {
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }
        return sb.toString().trim();
    }
}
