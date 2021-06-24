package com.kmk.java4;

/**
 * @author kemengkai
 * @create 2021-06-21 20:22
 *
 *
 *
 *  a instanceof A: 判断对象a是否是类A的实例。如果是，返回true，如果不是，返回false
 *  使用情景：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前先进行instanceof的判断，
 *  一旦返回true，就形象向下转型，如果是返回false就不进行向下转型
 *
 *
 *  如果a instanceof A 返回true，则 a instanceof B也返回true，
 *  其中，类B是类A的父类
 *
 */
public class InstanceofTest {
    public static void main(String[] args) {
        Person p1 = new Man();
        if (p1 instanceof Woman) {
            Woman w1 = (Woman) p1;
            w1.goShopping();
            System.out.println("************Woman**************");
        }
        if (p1 instanceof Man) {
            Man m1 = (Man) p1;
            m1.earnMoney();
            System.out.println("************Man**************");
        }

        if (p1 instanceof Person) {
            System.out.println("********Person*******");
        }
        if (p1 instanceof Object) {
            System.out.println("****************Object**************");
        }
    }
}
