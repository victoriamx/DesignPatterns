package DesignPattern;

interface Image{
	void play();
}
class RealImage implements Image{
	private String filename;
	public  RealImage(String filename) {
		// TODO Auto-generated constructor stub
		this.filename=filename;
		loadFromDisk(filename);
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("displaying "+filename);
	}
	private void loadFromDisk(String filename) {
		System.out.println("loading "+filename);
	}
}
class ProxyImage implements Image{
	private  RealImage realImage;
	private String filename;
	public ProxyImage(String filename) {
		this.filename=filename;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		if(realImage==null) {
			realImage=new RealImage(filename);
		}
		realImage.play();
	}
}

public class ProxyPatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image=new ProxyImage("smile.jpg");
		//首次磁盘加载
		image.play();
		//不需要再加载
		image.play();
	}
}
/*
 * output:
 * loading smile.jpg
 * displaying smile.jpg
 * displaying smile.jpg
 */
