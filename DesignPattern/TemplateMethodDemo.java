package DesignPattern;
/*
 * �����ඨ��ģ�巽�����㷨�Ǽ�
 * ������ʵ�ֳ��󷽷��������㷨
 */
abstract class AbstractPerson{
	public void goToSchool(){
		dressUp();
		takeThings();
	}
	protected abstract void  dressUp();
	protected abstract void  takeThings();
}
class Student extends AbstractPerson{
	@Override
	protected void dressUp() {
		System.out.println("school dress");
	}
	@Override
	protected void takeThings() {
		System.out.println("school things");
	}
}
class Teacher extends AbstractPerson{
	@Override
	protected void dressUp() {
		// TODO Auto-generated method stub
		System.out.println("teacher dressup");
	}
	@Override
	protected void takeThings() {
		// TODO Auto-generated method stub
		System.out.println("teacher things");
	}
}
public class TemplateMethodDemo {
	public static void main(String[] args) {
		AbstractPerson student=new Student();
		student.goToSchool();
		AbstractPerson teacher=new Teacher();
		teacher.goToSchool();
	}
}
