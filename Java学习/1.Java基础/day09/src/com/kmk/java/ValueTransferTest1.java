package com.kmk.java;

/**
 * @author 柯孟凯
 * @desc
 * @create 2021-06-04 16:04
 *
 * 方法形参的传递机制：值传递
 *
 * 1. 形参：方法定义时，声明的小括号内的参数
 *      实参：方法调用时，实际传递给形参的值
 * 2.值传递机制:
 *      2.1 如果参数是基本数据类型，此时实参赋值给形参的是，实参真实存储的数据值。
 *
 **/
public class ValueTransferTest1 {
    public static void main(String[] ages) {
        int m = 10;
        int n = 20;
        System.out.println("n = " + n + ", m = " + m);
        // 交换两个变量的值操作
        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m, n);
        System.out.println("n = " + n + ", m = " + m);
    }

    private void swap(int m, int n) {
        int tmp = m;
        m = n;
        n = tmp;
    }
}