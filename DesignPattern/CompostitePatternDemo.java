package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/*
 * 结构型的设计模式——用于有树状结构的
 * 三个角色
 * 抽象构件component
 * 树叶构件leaf
 * 树枝构件composite
 */
abstract class Component{
	public abstract void add(Component component);
	public abstract void remove(Component component);
	public abstract void display(int depth);
}
class Leaf extends Component{
	private String name;
	public Leaf(String name) {
		this.name=name;
	}
	@Override
	public void add(Component component) {
		// TODO Auto-generated method stub
		System.out.println("can't add to a leaf!");
	}
	@Override
	public void remove(Component component) {
		// TODO Auto-generated method stub
		System.out.println("can't remove from a leaf");
	}
	@Override
	public void display(int depth) {
		// TODO Auto-generated method stub
		System.out.println(depth+" "+name);
	}
}
class Composite extends Component{
	private String name;
	private List<Component> children=new ArrayList<Component>(); 
	public Composite(String name) {
		this.name=name;
	}
	@Override
	public void add(Component component) {
		// TODO Auto-generated method stub
		children.add(component);
	}
	@Override
	public void remove(Component component) {
		// TODO Auto-generated method stub
		children.remove(component);
	}
	@Override
	public void display(int depth) {
		// TODO Auto-generated method stub
		System.out.println(depth+" "+name);
		for(Component component:children)
			component.display(depth+1);
	}
}

public class CompostitePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Composite root=new Composite("--root");
		root.add(new Leaf("--leaf 1"));
		root.add(new Leaf("--leaf 2"));
		Composite composite1=new Composite("--composite 1");
		composite1.add(new Leaf("--leaf 3"));
		composite1.add(new Leaf("--leaf 4"));
		root.add(composite1);
		root.display(1);
	}

}
