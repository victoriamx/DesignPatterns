package DesignPattern;
//两脚插头
interface DBSocketInterface{
	public void powerWithTwoRound();
}
class DBSocket implements DBSocketInterface{
	public void powerWithTwoRound() {
		System.out.println("两脚插头");
	}
}

//三脚插头
interface GBSocketInterface{
	public void powerWithThreeRound();
}
class GBSocket implements GBSocketInterface{
	public void powerWithThreeRound() {
		System.out.println("三脚插头");
	}
}

//旅馆只能两脚插头充电
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

//添加适配器
class SocketAdapter implements DBSocketInterface{
	private GBSocketInterface gbSocket;
	public SocketAdapter(GBSocketInterface gbSocket) {
		this.gbSocket=gbSocket;
	}
	@Override 
	public void powerWithTwoRound() {
		gbSocket.powerWithThreeRound();//适配
	}
}

public class AdapterPatternDemo{
	public static void main(String[] args) {
		GBSocketInterface gbSocket=new GBSocket();
		Hotel hotel=new Hotel();
		SocketAdapter socketAdapter=new SocketAdapter(gbSocket);//需要适配器
		hotel.setSocket(socketAdapter);//利用了SocketAdapter实现了DBSocketInterface，向上转型
		hotel.charge();
	}
}