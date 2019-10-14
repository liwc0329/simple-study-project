package com.g7go.encryptiondecryption.base64;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;

/**
 * @author lwc
 * @date 2019-10-06 10:30
 */
public class Test {

    private final static String CONTENT = "commonsCodecBase64测试";


    private void base64Test() {
        System.out.println("===============base64======================");
        Base64 base64 = new Base64();
        String s = base64.encodeToString(CONTENT.getBytes());
        System.out.println(s);
        String s1 = new String(base64.decode(s));
        System.out.println(s1);
    }

    private void md5Test() {
        System.out.println("===============MD5======================");
        String result = DigestUtils.md5Hex(CONTENT);
        System.out.println(result);
    }

    private void URLCodecTest() throws UnsupportedEncodingException, DecoderException {
        System.out.println("===============URLCodec======================");
        URLCodec codec = new URLCodec();
        String s = codec.encode(CONTENT, "utf-8");
        System.out.println(s);
        String s1 = codec.decode(s, "utf-8");
        System.out.println(s1);
    }


    public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
        new Test().base64Test();
        new Test().md5Test();
        new Test().URLCodecTest();
    }
}
