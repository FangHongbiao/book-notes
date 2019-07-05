package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 19:51
 *
 * @author hbfang
 */

public class PermGenGC {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //加入常量池
            String t = String.valueOf(i).intern();
        }
    }

}
