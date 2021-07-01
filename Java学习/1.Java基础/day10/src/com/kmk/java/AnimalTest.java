package com.kmk.java;

/**
 * @author 柯孟凯
 * @desc 面向对象的特征一：封装与隐藏
 * @create 2021-06-08 10:03
 * <p>
 * 一、问题的引入
 * 当我们创建一个类的对象以后，我们可以通过“对象.属性"的方式，对对象的属性进行赋值。
 * 这里，赋值操作要受到属性的数据类型和存储范围的制约。除此之外，没有其他制约条件。
 * 但是在实际问题中，我们往往需要给属性赋值加入额外的限制条件。
 * 这个条件就不能在属性声明时体现，我们只能通过方法进行限制条件的添加。(比如: set,get)
 * 同时，我们需要避免用户再使用“对象.属性"的方式对属性进行赋值。则需要将属性声明为私有的(private)
 * --> 此时，针对与属性就体现了封装性
 * <p>
 * 二、封装性的体现:
 *  我们将类的属性(xxx)私有化(private)，同时，提供公共的(public)方法来获取（getXxx）和设置(setXxx)此属性的值
 *
 *  拓展：封装性的体现：
 *      ① 如上
 *      ② 不对外暴露的私有方法
 *      ③ 单例模式
 *      ......
 *
 * 三、封装性的体现，需要权限修饰符来配合。
 *  1. Java规定的4种权限：(从小到大排列): private、缺省(default, 什么都不写)、protected、public
 *  2.
 **/
public class AnimalTest {
    public static void main(String[] ages) {
        Animal a = new Animal();
        a.name = "大黄";
        a.age = 1;
        a.show();
        a.eat();
        a.setLegs(4);
        System.out.println("Legs: " + a.getLegs());
    }
}

class Animal {

    String name;
    int age;

    /**
     * 腿的数量
     */
    private int legs;

    public void eat() {
        System.out.println("动物进食！");
    }

    /**
     * 提供关于属性Legs的get和set方法
     * @param legs
     */
    public void setLegs(int legs) {
        if (legs >= 0 && legs % 2 == 0) {
            this.legs = legs;
        } else {
            this.legs = 0;
        }
    }
    public int getLegs() {
        return this.legs;
    }

    public void show() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("legs = " + legs);
    }
}