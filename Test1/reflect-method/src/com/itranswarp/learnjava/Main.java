package com.itranswarp.learnjava;

import java.lang.reflect.Method;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射调用setName和setAge方法:
		Method p_Method_setName = p.getClass().getMethod("setName", String.class);
		Method p_Method_setAge = p.getClass().getMethod("setAge", int.class);

		p_Method_setName.setAccessible(true);
		p_Method_setName.invoke(p, "Xiao Ming");
		p_Method_setAge.setAccessible(true);
		p_Method_setAge.invoke(p, 20);

		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}
