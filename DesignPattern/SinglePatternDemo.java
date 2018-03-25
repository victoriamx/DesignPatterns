package DesignPattern;

/*
 * �������ģʽ����������ʵ��������ĸ���ֻ��һ��
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
