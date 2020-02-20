package com.demo;

public class TestDummy {
    public void method1()
    {
        method2();
    }
    public void method2() {
        try {
            System.out.println(1/0);
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        TestDummy testDummy = new TestDummy();
        testDummy.method1();
    }

}
