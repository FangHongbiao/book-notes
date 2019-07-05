package com.fhb.g1.chapter1;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/4
 * Time: 9:10
 *
 * @author hbfang
 */

public class JVMDemoTest {

    public static String toMemoryInfo () {
        Runtime runtime = Runtime.getRuntime();

        long freeMemory = runtime.freeMemory() / 1024 / 1024;
        long totalMemory = runtime.totalMemory() / 1024 / 1024;

        return "freeMemory: " + freeMemory + "M \t" + "totalMemory: " + totalMemory;
    }

    public static void main(String[] args) {
        System.out.println(toMemoryInfo());
    }
}
