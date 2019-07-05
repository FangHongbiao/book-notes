package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 16:24
 *
 * @author hbfang
 */

public class TestJVMStack1 {

    private int count = 0;

    /**
     * 没有出口的递归函数
     */
    public void recursion(long a, long b, long c) throws InterruptedException {
        long d = 0, e = 0, f = 0;
        //每次调用深度加1
        count++;
        //递归
        recursion(a, b, c);
    }

    public void testStack() {
        try {
            recursion(1L, 2L, 3L);
        } catch (Throwable e) {
            //打印栈溢出的深度
            System.out.println("deep of stack is " + count);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestJVMStack1 ts = new TestJVMStack1();
        ts.testStack();
    }
}

