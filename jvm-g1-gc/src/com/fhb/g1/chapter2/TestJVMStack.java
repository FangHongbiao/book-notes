package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 16:37
 *
 * @author hbfang
 */

public class TestJVMStack {

    private int count = 0;

    public void recursion(){
        //每次调用深度加1
        count++;
        //递归
        recursion();
    }

    public void testStack(){
        try{
            recursion();
        }catch(Throwable e){
            //打印栈溢出的深度
            System.out.println("deep of stack is "+count);
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        TestJVMStack ts = new TestJVMStack();
        ts.testStack();
    }
}

