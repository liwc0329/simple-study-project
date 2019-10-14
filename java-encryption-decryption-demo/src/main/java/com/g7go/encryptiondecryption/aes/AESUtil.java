package com.g7go.encryptiondecryption.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {

    private static final String KEY_AES = "AES/CBC/PKCS5Padding";

    public static String encrypt(String src, String key) throws Exception {
        if (key == null || key.length() != 16) {
            throw new Exception("key不满足条件");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes());
        return byte2hex(encrypted);
    }

    public static String decrypt(String src, String key) throws Exception {
        if (key == null || key.length() != 16) {
            throw new Exception("key不满足条件");
        }
        byte[] raw = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encrypted1 = hex2byte(src);
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original);
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (byte value : b) {
            stmp = (Integer.toHexString(value & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }

}