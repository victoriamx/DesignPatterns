package DesignPattern;

import java.util.Date;

//中介者
class ChatRoom{
	public static void ShowMessage(User user,String message) {
		System.out.println(new Date().toString()
		         + " [" + user.getName() +"] : " + message);
	}
}
class User{
	private String name;
	public User(String string) {
		name=string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void sendMessage(String message) {
		ChatRoom.ShowMessage(this, message);//利用了static方法的特性
	}
}

public class MediatorPatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User aUser=new User("a");
		User bUser=new User("b");
		aUser.sendMessage("hi");
		bUser.sendMessage("hello");
	}

}
