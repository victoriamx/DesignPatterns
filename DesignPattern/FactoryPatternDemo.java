package DesignPattern;

/*
 * 工厂设计模式
 * java开发中使用最多的一种
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

//定义工厂类，此类不提供属性
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

//客户端
public class FactoryPatternDemo {
	public static void main(String[] args) {
		Fruit fruit=Factory.getInstance("orange");
		fruit.eat();
	}

}
