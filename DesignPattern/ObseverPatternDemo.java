package DesignPattern;

import java.util.ArrayList;
import java.util.List;
/*
 * ����ϵͳ�µ�: 
 * �û�����ĳ����Ʒ��һ������, 
 * ��Ҫ: ֪ͨ���ϵͳ���ٿ�桢֪ͨ�̼�ϵͳ������֪֧ͨ��ϵͳ��Ǯ��
 * ��������֪ͨ��ϵ����ʹ��ǰ�û���ע���̼�
 */
//����֪ͨ��
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
//����֪ͨ��
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
		notifyAllObservers();//�ؼ���
	}
	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for(Observer observer:observers)
			observer.update(this);
	}
}
//����۲���
interface Observer{
	void update(Subject subject);
}
//����۲���
class WareHouseObsever implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		System.out.println("���ϵͳ���յ���Ϣ [" + state + "], ���ٿ��");}
}
class PayObserver implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		System.out.println("֧��ϵͳ���յ���Ϣ [" + state + "], ������Ǯ");
	}
}
class RelationObsever implements Observer{
	private int state;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		state=subject.getState();
		if(state==1)
			System.out.println("��ϵϵͳ���յ���Ϣ [" + state + "], ��ǰ�û��ѹ�ע�õ���");
		else if(state==0)
			System.out.println("��ϵϵͳ���յ���Ϣ [" + state + "], ��ǰ�û�ȡ����ע�õ���");

	}
}

public class ObseverPatternDemo {
	public static void main(String[] args) {
		Subject subject=new OrderObject();
		Observer observer1=new WareHouseObsever();
		Observer observer2=new PayObserver();
		Observer observer3=new RelationObsever();
		//ע��
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
