package com.imudges.members.util;

import java.security.MessageDigest;

/**
 * Created by likole on 10/22/17.
 */
public class SHAUtil {
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        sha = MessageDigest.getInstance("SHA");

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}