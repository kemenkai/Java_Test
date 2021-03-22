/*
 * 基本数据类型之间的运算规则:
 *
 * 前提: 这里讨论只是7种基本数据类型变量间的运算。不包含boolean
 * 
 * 1.自动类型提升：
 *   结论: 当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
 *   byte 、char 、short --> int --> long --> float --> double
 *   特别的：byte、char、short 三种变量在做运算时, 结果为int型
 *   小的存储类型，相加时，结果容易超过当前存储类型的容量
 *
 * 2.强制类型转换
 * 
 * 
 * 说明：此时的容量大小指的是，表示数的范围的大和小。比如：float容量要大于long的容量
 */

class VariableTest2 {
    public static void main(String[] args) {
        System.out.println();
    }
}
