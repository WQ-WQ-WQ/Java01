package com.cy.java.oop.cls;

import java.util.Arrays;

class ClassA{
	static {//类加载时可以执行静态代码块,但不一定会执行.
		System.out.println("static{}");
	}
}
//检测类的加载?
//跟踪类的加载过程?-XX:+TraceClassLoading
public class TestClassObject01 {
	public static void main(String[] args)throws Exception {
	   System.out.println("args[]="+Arrays.toString(args));
	   //Class.forName("com.cy.java.oop.cls.ClassA");
	   Class.forName("com.cy.java.oop.cls.ClassA",
				false,//initialize (为true会进行类的初始化,此时会执行静态代码块)
				ClassLoader.getSystemClassLoader());//loader
      //Class<?> c1=ClassA.class;//会触发类加载,但不会初始化类,所以不会执行static代码块
	}
}
