package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 16:48
 *
 * @author hbfang
 */

/**
 * TODO 有点问题
 */
public class TestGC {
    public static void test1() {
        byte[] a = new byte[6 * 1024 * 1024];

        System.gc();
        System.out.println("first explict gc over");
    }

    public static void main(String[] args) {
        TestGC.test1();
    }
}

