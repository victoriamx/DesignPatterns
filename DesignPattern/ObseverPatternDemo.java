package DesignPattern;

import java.util.ArrayList;
import java.util.List;
/*
 * 电商系统下单: 
 * 用户购买某件商品下一个订单, 
 * 需要: 通知库存系统减少库存、通知商家系统发货、通知支付系统收钱、
 * 甚至还会通知关系中心使当前用户关注该商家
 */
//抽象通知者
abstract class Subject{
	protected List<Observer> observers=new ArrayList<>();
	public void attach(Observer observer) {
	    observers.add(observer);
	}
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	public abstract void notifyAllObservers();
	public abstract void setState(int state);
	public abstract int getState();
}
//具体通知者
class OrderObject extends Subject{
	private int state;
	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}
	@Override
	public void setState(int state) {
		// TODO Auto-generated method stub
		this.state=state;
		notifyAllObservers();//关键点
	}
	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for(Observer observer:observers)
			observer.update(this);
	}
}
//抽象观察者
interface Observer{
	void update(Subject subject);
}
//具体观察者
class WareHouseObsever implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		System.out.println("库存系统接收到消息 [" + state + "], 减少库存");}
}
class PayObserver implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		System.out.println("支付系统接收到消息 [" + state + "], 正在收钱");
	}
}
class RelationObsever implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		if(state==1)
			System.out.println("关系系统接收到消息 [" + state + "], 当前用户已关注该店铺");
		else if(state==0)
			System.out.println("关系系统接收到消息 [" + state + "], 当前用户取消关注该店铺");

	}
}

public class ObseverPatternDemo {
	public static void main(String[] args) {
		Subject subject=new OrderObject();
		Observer observer1=new WareHouseObsever();
		Observer observer2=new PayObserver();
		Observer observer3=new RelationObsever();
		//注册
		subject.attach(observer1);
		subject.attach(observer2);
		subject.attach(observer3);
		subject.setState(1);
		System.out.println("------");
		
		subject.detach(observer2);
		subject.detach(observer1);
		subject.setState(0);
	}

}
