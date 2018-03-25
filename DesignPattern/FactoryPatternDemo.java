package DesignPattern;

/*
 * �������ģʽ
 * java������ʹ������һ��
 */

interface Fruit{
	public void eat();
}

class Apple implements Fruit{
	public void eat() {
		System.out.println("apple");
	}
}
class Orange implements Fruit{
	public void eat() {
		System.out.println("orange");
	}
}

//���幤���࣬���಻�ṩ����
class Factory{
	public static Fruit getInstance(String className) {
		if(className.equals("apple"))
			return new Apple();
		else if(className.equals("orange"))
			return new Orange();
		else 
			return null;
	}
}

//�ͻ���
public class FactoryPatternDemo {
	public static void main(String[] args) {
		Fruit fruit=Factory.getInstance("orange");
		fruit.eat();
	}

}
