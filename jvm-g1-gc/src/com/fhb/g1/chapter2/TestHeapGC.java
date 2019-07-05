package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 18:58
 *
 * @author hbfang
 */

/**
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
 */
public class TestHeapGC {
    public static void main(String[] args) {
        byte[] b1 = new byte[1024 * 1024 / 2];
        byte[] b2 = new byte[1024 * 1024 * 8];
        b2 = null;
        //进行一次年轻代GC
        b2 = new byte[1024 * 1024 * 8];
        System.gc();
    }
}
