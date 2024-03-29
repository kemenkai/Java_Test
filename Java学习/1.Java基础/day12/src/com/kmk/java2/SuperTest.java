package com.kmk.java2;

/**
 * @author kemengkai
 * @create 2021-06-17 8:23
 *
 * super关键字的使用
 *      1. super理解为：父类的
 *      2. super可以用来调用：属性、方法、构造器
 *      3. super 使用说明
 *          3.1 我们可以在子类的方法或构造器中，通过使用"super.属性"或"super.方法"的方式，
 *          显式的调用父类中声明的属性或方法。但是通常情况下，我们习惯省略"super."
 *          3.2 特殊情况（属性）：当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的属性时，
 *          则必须显式的使用"super.属性"的方式，表明调用的时父类中声明的属性
 *          3.3 特殊情况（方法）：当子类重写了父类中的方法以后，我们想在子类的方法中调用父类中被重写的方法时，
 *          则必须显式的使用"super.方法"的方式，表明调用的时父类中被重写的方法
 *
 *      4. super调用构造器
 *          4.1 我们可以在子类的构造器中显式的使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
 *          4.2 "super(形参列表)"的使用，必须声明在子类构造器的首行!
 *          4.3 我们在类的构造器中，针对于"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
 *          4.4 在构造器的首行，没有显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的时父类中空参的构造器: super();
 *          4.5 在类的多个构造器中，至少有一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器
 *
 *
 */
public class SuperTest {
    public static void main(String[] ages) {
        Student student = new Student();
        student.show();

        System.out.println();
        student.study();

        Student student1 = new Student("Tom", 21, "IT");
        student1.show();

    }
}
