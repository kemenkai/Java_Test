package com.kmk.java2;

/**
 * @author kemengkai
 * @create 2021-06-17 8:22
 */
public class Student extends Person {
    String major;
    /**
     * 学号
     */
    int id = 1002;

    public Student() {
    }

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生多吃有营养的食物");
    }

    public void study() {
        System.out.println("学生学习知识");
        this.eat();
        super.eat();
    }

    public void show() {
        System.out.println("name: " + name + ", age: " + age);
        System.out.println("id = " + this.id);
        System.out.println("id = " + super.id);
    }
}
