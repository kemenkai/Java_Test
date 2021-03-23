/*
 * 基本数据类型之间的运算规则:
 *
 * 前提: 这里讨论只是7种基本数据类型变量间的运算。不包含boolean
 * 
 * 1.自动类型提升：
 *
 * 2.强制类型转换：自动类型提升运算的逆运算
 *  2.1 需要使用强转符：()
 *  2.2 注意点：强制类型转换，可能导致精度损失
 * 
 * 
 * 说明：此时的容量大小指的是，表示数的范围的大和小。比如：float容量要大于long的容量
 */

class VariableTest2 {
    public static void main(String[] args) {
        // 精度损失举例1
        double d1 = 12.3;
        int i1 = (int) d1; // 截断操作, 损失精读
        System.out.println(i1);

        // 没有精度损失
        long l1 = 123;
        short s2 = (short) l1;

        // 精度损失举例2
        int i2 = 128;
        byte b = (byte) i2;
        System.out.println(b); // -128
    }
}
