package com.service.platform.user.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class RandomUtils {

    public static String nextRandomNumber(int length){
        return nextRandomText(NUMBER_CODES, length);
    }

    public static String nextRandomNoZeroNumber(int length){
        return nextRandomText(NUMBER_NO_ZERO_CODES, length);
    }

    public static String nextAlphabetLetter(int length){
        return nextRandomText(ALPHABET_UPPER_LOWER_LETTER_CODES, length);
    }

    public static String nextAlphabetNumberLetter(int length){
        return nextRandomText(ALPHABET_NUMBER_LETTER_CODES, length);
    }


    public static String nextRandomText(String randomSource, int length){
        StringBuffer randomValues = new StringBuffer(length);

        while(randomValues.length() < length){
            randomValues.append(next(randomSource));
        }

        return randomValues.toString();
    }



    public synchronized static String next(String text){
        return String.valueOf(text.charAt(Random.nextInt(text.length())));
    }

    public static int randomRange(int range){
        return Random.nextInt(range);
    }

    private static Random Random = new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());

    private static final String NUMBER_CODES = "01234567890123456789";

    private static final String NUMBER_NO_ZERO_CODES = "123456789123456789";

    private static final String ALPHABET_UPPER_LETTER_CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String ALPHABET_LOWER_LETTER_CODES = "abcdefghijklmnopqrstuvwxyz";

    private static final String ALPHABET_UPPER_LOWER_LETTER_CODES = ALPHABET_UPPER_LETTER_CODES + ALPHABET_LOWER_LETTER_CODES;

    private static final String ALPHABET_NUMBER_LETTER_CODES = NUMBER_CODES
            + ALPHABET_UPPER_LETTER_CODES + NUMBER_CODES
            + ALPHABET_LOWER_LETTER_CODES + NUMBER_CODES;


    public static void main(String[] args) {
//        System.out.println(nextRandomNumber(10));
//        System.out.println(nextRandomNoZeroNumber(10));
//        System.out.println(nextAlphabetLetter(10));
//        System.out.println(nextAlphabetNumberLetter(10));

        String orig = "appKey:c5256999cb8a28f6127c7f41";
        String desc = Base64.getEncoder().encodeToString(orig.getBytes(StandardCharsets.UTF_8));
        System.out.println("加密后的字符串为:"+desc);

//        String unDecodeStr=new String(Base64.getDecoder().decode(desc),StandardCharsets.UTF_8);
//        System.out.println("解密后的字符串为"+unDecodeStr);



    }

}
