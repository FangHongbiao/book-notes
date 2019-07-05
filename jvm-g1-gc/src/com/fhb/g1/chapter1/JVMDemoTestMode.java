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

public class JVMDemoTestMode {

    public static String toMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();

        long freeMemory;
        long totalMemory;
        String result = null;

        for (int i = 0; i < 100000; i++) {
            freeMemory = runtime.freeMemory() / 1024 / 1024;
            totalMemory = runtime.totalMemory() / 1024 / 1024;
            result = "freeMemory: " + freeMemory + "M \t" + "totalMemory: " + totalMemory;
        }
        return result;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        System.out.println("Memory info: " +toMemoryInfo());
        System.out.println(System.currentTimeMillis() - b);
    }
}
