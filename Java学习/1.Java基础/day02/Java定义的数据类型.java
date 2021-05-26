/*
 * Java定义的数据类型
 * 一、变量按照数据类型来分：
 *       基本数据类型：
 *         整形型: byte \ short \ int \ long
 *         浮点型: float \ double
 *         字符型: char
 *         布尔型: boolean
 *       引用数据类型:
 *         类(class)
 *         接口(interface)
 *         数组(array)
 *
 * 二、变量在类中声明的位置
 *       成员变量 vs 局部变量
 */

class VariableTest {
    public static void main(String[] args) {
	// 1. 整型：byte(1字节=8bit) short(2字节) \ int(4字节) \ long(8字节)
	// 1.1 byte范围：-128 ~ 127
//        System.out.println(myAge);
	// 1.2 声明long型变量，必须以"l"或"L"结尾，声明为long类型
	// 1.3 通常，定义整形变量时，使用int类型。
	short s1 = 128;
	int i1 = 1234;
	long l1 = 123456789L;

	// 2. 浮点型：float(4字节) \ double(8字节)
	// 2.1 浮点型，表示带小数点的数值
	// 2.2 float表示数值的范围比long还大
	double d1 = 123.3;
	// 2.3 定义float类型变量时，变量要以"f"或"F"结尾
	float f1 = 12.3F;
	// 2.4 通常，定义浮点型变量时，使用double
	
	// 3. 字符型: char(1字符 = 2字节)
	// 3.1 定义char型变量，通常使用一对''，内部只能写一个字符
	char c1 = 'a';
	// 编译不通过
	// c1 = 'ab';
	// 3.2 表示方式：1.声明一个字符 2.转义字符
	char c5 = '\n'; // 换行
	c5 = '\t'; // 制表符
	System.out.print("Hello" + c5);
	System.out.println("World");

	char c6 = '\u0043';
	System.out.println(c6);
	// 4.布尔型: boolean
	// 4.1 只能取两个值之一：ture, false
	// 4.2 常常在条件判断、循环结构中使用
	boolean bb1 = true;
	System.out.println(bb1);
	boolean isMarried = true;
	if (isMarried) {
	   System.out.println(isMarried);
	} else {
	   System.out.println(isMarried);
	}
    }
}
