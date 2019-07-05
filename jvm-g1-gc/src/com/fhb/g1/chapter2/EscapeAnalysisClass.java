package com.fhb.g1.chapter2;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/5
 * Time: 17:26
 *
 * @author hbfang
 */


class B {
    public void printClassName(EscapeAnalysisClass g) {
        System.out.println(g.getClass().getName());
    }
}

public class EscapeAnalysisClass {

    public static B b;

    /**
     * //给全局变量赋值，发生逃逸
     */
    public void globalVariablePointerEscape() {
        b = new B();
    }

    public B methodPointerEscape() {//方法返回值，发生逃逸
        return new B();
    }

    public void instancePassPointerEscape() {
        //实例引用发生逃逸
        methodPointerEscape().printClassName(this);
    }
}


