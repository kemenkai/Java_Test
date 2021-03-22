/*
 * 标识符的使用
 * 1.标识符：凡是自己可以起名字的地方都叫标识符
 *    比如：类名、变量名、方法名、接口名、包名....
 *
 * 2.标识符的命名规则 --> 如果不遵守如下的规则，编译不通过！需要大家严格遵守。
 *    由26个英文字母大小写，0-9，_或$组成
 *    数字不可以开头
 *    Java中严格区分大小写，长度无限制
 *    标识符不能包含空格。
 *
 * 3.Java中的名称命名规范: --> 如果不遵守如下的规范，编译可以通过！建议大家遵守。
 *    包名：多单词组成时所有字母都小写：xxxyyyzzz
 *    类名、接口名：多单词组成时，所有单词的首字母大写：XxxYyyZzz
 *    变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写: xxxYyyZzz
 *    常量名：所有字母都大写。多单词时每个单词用下划线链接：XXX_YYY_ZZZ
 * 4.注意事项
 *    注意1：在起名字时，为了提高阅读性，要尽量有意义，"见名知意"。
 *    注意2：java采用unicode字符集，因此标识符也可以使用汉字声明，但是不建议使用。
 */
class IdentifierTest {
    public static void main (String[] args) {
        // int myNumber = 1001;
        int mynumber = 1002;
	System.out.println(myNumber);
    }
}
// 示例1
class Hello1_$ {

}

// 错误1
//class 1Hello {
//}

// 示例2，包含关键字
class static1 {

}

// 示例3，java严格大小写，static小写的,Static大写的S
class Static {

}
