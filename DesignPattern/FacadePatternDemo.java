package DesignPattern;
//子系统
class CPU{
	public void start() {
		System.out.println("cpu is start!");
	}
	public void shutDown() {
		System.out.println("cpu is shutDown!");
	}
}
class Disk{
	public void start() {
		System.out.println("Disk is start!");
	}
	public void shutDown() {
		System.out.println("Disk is shutDown!");
	}
}
class Memory{
	public void start() {
		System.out.println("Memory is start!");
	}
	public void shutDown() {
		System.out.println("Memory is shutDown!");
	}
}

//门面系统
class Computer{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public Computer() {
		cpu=new CPU();
		memory=new Memory();
		disk=new Disk();
	}
	public void start(){
		cpu.start();
		memory.start();
		disk.start();
	}
	public void shutDown() {
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
	}
}

public class FacadePatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer=new Computer();
		computer.start();
		System.out.println("------working------");
		computer.shutDown();
	}
}
