package DesignPattern;
//���Ų�ͷ
interface DBSocketInterface{
	public void powerWithTwoRound();
}
class DBSocket implements DBSocketInterface{
	public void powerWithTwoRound() {
		System.out.println("���Ų�ͷ");
	}
}

//���Ų�ͷ
interface GBSocketInterface{
	public void powerWithThreeRound();
}
class GBSocket implements GBSocketInterface{
	public void powerWithThreeRound() {
		System.out.println("���Ų�ͷ");
	}
}

//�ù�ֻ�����Ų�ͷ���
class Hotel{
	private DBSocketInterface dbSocket;
	public Hotel() {}
	public Hotel(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }
	public void setSocket (DBSocketInterface dbSocket){
        this.dbSocket = dbSocket;
    }
	public void charge() {
		dbSocket.powerWithTwoRound();
	}
}

//���������
class SocketAdapter implements DBSocketInterface{
	private GBSocketInterface gbSocket;
	public SocketAdapter(GBSocketInterface gbSocket) {
		this.gbSocket=gbSocket;
	}
	@Override 
	public void powerWithTwoRound() {
		gbSocket.powerWithThreeRound();//����
	}
}

public class AdapterPatternDemo{
	public static void main(String[] args) {
		GBSocketInterface gbSocket=new GBSocket();
		Hotel hotel=new Hotel();
		SocketAdapter socketAdapter=new SocketAdapter(gbSocket);//��Ҫ������
		hotel.setSocket(socketAdapter);//������SocketAdapterʵ����DBSocketInterface������ת��
		hotel.charge();
	}
}