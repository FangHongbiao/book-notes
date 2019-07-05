package com.fhb.g1.chapter1;


/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/4
 * Time: 10:18
 *
 * @author hbfang
 */

public class StringInternDemo {

    public static void main(String[] args) {

        String s1 = new String("1");
        s1.intern();
        String s2 = "1";

        String s3 = new String("1") + new String("2");
        s3.intern();
        String s4 = "12";

        System.out.println(s1 == s2);
        System.out.println(s4 == s3);
    }
}
