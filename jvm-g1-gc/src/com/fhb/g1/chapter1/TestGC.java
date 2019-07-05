package com.fhb.g1.chapter1;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 9:26
 *
 * @author hbfang
 */

public class TestGC {

    public static void main(String[] args) {
        new TestGC();
        System.gc();
        TestGC testGC = new TestGC();
        testGC = null;
        System.runFinalization();
    }
}

