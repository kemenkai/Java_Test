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
 *
 * 2.值传递机制:
 *      2.1 如果参数是基本数据类型，此时实参赋值给形参的是，实参真实存储的数据值。
 *      2.2 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。
 *
 **/
public class ValueTransferTest2 {
    public static void main(String[] ages) {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("n = " + data.n + ", m = " + data.m);
        // 交换两个变量的值操作
//        int tmp = data.m;
//        data.m = data.n;
//        data.n = tmp;
        ValueTransferTest2 test = new ValueTransferTest2();
        test.swap(data);
        System.out.println("n = " + data.n + ", m = " + data.m);
    }

    public void swap(Data data){
        int tmp = data.m;
        data.m = data.n;
        data.n = tmp;
    }
}

class Data{
    int m;
    int n;
}