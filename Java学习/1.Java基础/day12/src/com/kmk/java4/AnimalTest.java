package com.kmk.java4;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kemengkai
 * @create 2021-06-18 9:29
 *
 * 多态性的使用举例一：
 */
public class AnimalTest {
    public static void main(String[] ages) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());
        test.func(new Cat());
    }

    public void func(Animal animal) {
        animal.eat();
        animal.shout();
    }
}

class Animal {
    public void eat() {
        System.out.println("动物：进食");
    }

    public void shout() {
        System.out.println("动物：叫");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void shout() {
        System.out.println("汪！汪！汪！");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void shout() {
        System.out.println("喵！喵！喵！");
    }
}

/**
 * 举例二
 */
class Order {
    public void method(Object obj) {

    }
}

/**
 * 举例三
 */
class Driver {
    /**
     *
     * connection = new MySqlConnection
     * connection = new OracleConnection
     */
    public void doData(Connection connection) throws SQLException {
        // 规范的步骤操作数据
        //        connection.method1();
        //        connection.method2();
        //        connection.method3();
    }
}