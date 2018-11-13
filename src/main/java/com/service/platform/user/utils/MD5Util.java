package com.service.platform.user.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static void main(String[] args) {


        String result = DigestUtils.md5Hex("222");
        System.out.println(result);


    }

}
