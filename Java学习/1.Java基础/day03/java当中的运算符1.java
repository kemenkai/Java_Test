/*
    算数运算符：
        +: 正号，加，字符串连接
        -: 负号,减
        *: 乘
        /: 除
        %: 取模（取余）
        ++: 自增，放在前后会影响取值先后顺序
        --: 自减，放在前后会影响取值先后顺序
*/

class ArTest
{
    public static void main(String[] args) {
        // 除号： /
        int num1 = 12;
        int num2 = 5;
        int result1 = num1 / num2;
        System.out.println(result1); // 2

        int result2 = num1 / num2 * num2;
        System.out.println(result2); // 10

        double result3 = num1 / num2;
        System.out.println(result3); // 2.0

        double result4 = num1 / num2 + 0.0; // 2.0
        double result5 = num1 / (num2 + 0.0); // 2.4
        double result6 = (double) num1 / (num2 + 0.0); // 2.4
        System.out.println(result6); // 2.4

        // %: 取余运算
        // 结果的符号与被模数的符号相同
        // 开发中，经常使用%来判断能否被除尽的情况
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1);

        int m2 = 12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2);

        int m3 = 12;
        int n3 = 5;
        System.out.println("m3 % n4 = " + m3 % n3);

        int m4 = 12;
        int n4 = 5;
        System.out.println("m4 % n4 = " + m4 % n4);

        //(前)++ : 先自增1，后做其他运算
        //(后)++ : 先做其他运算，后自增1
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ", b1 = " + b1);

        // 注意点
        short s1 = 10;
        // s1 = s1 + 1; // 编译失败，类型错误，1为 int型
        // s1 = (short) (s1 + 1); // 正确的
        s1++; // 自增1，不会改变本身变量的数据类型
        System.out.println("s1 = " + s1);
        
        // 问题1
        byte bb1 = 127;
        bb1++;
        System.out.println("bb1 = " + bb1); // -128

        //(前)--: 先自减1，后做其他运算
        //(后)--: 先做其他运算，后自减1
        int a2 = 10;
        int b2 = a2--;
        System.out.println("a2 = " + a2 + ", b2 = " + b2);

    }
}