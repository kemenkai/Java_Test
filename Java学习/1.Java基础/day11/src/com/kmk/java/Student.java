package com.kmk.java;

/**
 * @author kemengkai
 * @create 2021-06-14 15:31
 */
public class Student extends Person {
//    String name;
//    int age;
    String major;

    public Student() {
    }

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

//    public void eat() {
//        System.out.println("吃饭");
//    }

//    public void sleep() {
//        System.out.println("睡觉");
//    }

    public void study() {
        System.out.println("学习");
    }

    public void show() {
        System.out.println("name: " + name + ", age: " + age);
    }
}
