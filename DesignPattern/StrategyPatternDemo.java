package DesignPattern;
interface Strategy{
	public int doOperation(int a,int b);
}
class add implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
}
class sub implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}
}
class multiply implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}
}

//context类
class Context{
	private Strategy strategy;//引用
	public Context(Strategy strategy) {
		this.strategy=strategy;
	}
	public int executeStrategy(int a,int b) {
		return strategy.doOperation(a, b);
	}
}

public class StrategyPatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context=new Context(new add());//改变策略后就不一样
		System.out.println(context.executeStrategy(10, 5));
		
		context=new Context(new sub());
		System.out.println(context.executeStrategy(10, 5));
		
		context=new Context(new multiply());
		System.out.println(context.executeStrategy(10, 5));
	}

}
