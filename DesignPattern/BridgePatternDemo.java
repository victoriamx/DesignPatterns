package DesignPattern;

/*
 * �Ž�ģʽ
 * ���̳й�ϵת��Ϊ�ۺϹ�ϵ����С�����
 * �����˼̳е����
 */

//�ֻ����
abstract class HandSetSoft{
	public abstract void run();
}
class HandSetGame extends HandSetSoft{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("game running!");
	}
}
class HandSetAdressList extends HandSetSoft{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("addresslist running!");
	}
}
//�ֻ�Ʒ��
abstract class HandSetBrand{
	HandSetSoft handSetSoft;
	public void setHandSetSoft(HandSetSoft handSetSoft) {
		this.handSetSoft=handSetSoft;
	}
	public abstract void run();
}
class HandSetBrandA extends HandSetBrand{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		handSetSoft.run();
	}
}

public class BridgePatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandSetBrand handSetBrand=new HandSetBrandA();
		handSetBrand.setHandSetSoft(new HandSetGame());
		handSetBrand.run();
		handSetBrand.setHandSetSoft(new HandSetAdressList());
		handSetBrand.run();
	}

}
