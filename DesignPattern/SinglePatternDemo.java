package DesignPattern;

/*
 * 单例设计模式：控制类中实例化对象的个数只有一个
 */

class Singleton{
	private final static Singleton instance=new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return instance;
	}
	public void print() {
		System.out.println("hello world!");
	}
}

public class SinglePatternDemo {
	public static void main(String[] args) {
		Singleton singleton=Singleton.getInstance();
		singleton.print();
	}
}
