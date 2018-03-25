package DesignPattern;

import java.util.Date;

//�н���
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
		ChatRoom.ShowMessage(this, message);//������static����������
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
