package com.isatk.land.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * Date: 8/26/15 2:50 PM
 * Author: Richard
 */
public class MD5 {

    private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * 将字节转化为16进制字符串
     * @param n
     * @return
     */
    private static String byteToHexString(byte n) {
        int a = n;
        if (a < 0) {
            a = 256 + a;
        }
        int d1 = a / 16;
        int d2 = a % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 字节数组转化为16进制字符串
     * @param n
     * @return
     */
    private static String byteArrayToHexString(byte[] n) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n.length; i++) {
            stringBuffer.append(byteToHexString(n[i]));
        }
        return stringBuffer.toString();
    }

    /**
     * 对纯文本进行MD5加密
     * @param plainText
     * @return
     */
    public static String Encrypt(String plainText) {
        if (plainText != null) {
            try {
                //根据指定的算法名称返回一个摘要对象
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = messageDigest.digest(plainText.getBytes());
                //将指定数组转化为16进制字符串
                return byteArrayToHexString(results);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
