package com.kmk.java2;

/**
 * @author kemengkai
 * @create 2021-06-17 8:22
 */
public class Person {

    String name;
    int age;
    /**
     * 身份证号
     */
    int id = 1001;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    public void walk() {
        System.out.println("人走路");
    }
}
