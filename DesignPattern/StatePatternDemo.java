package DesignPattern;
/*
 * 可以用于实现状态机
 */
interface State{
	public void doAction(Contexts context);
}
class StartState implements State{
	@Override
	public void doAction(Contexts context) {
		// TODO Auto-generated method stub
		System.out.println("start doing!");
		context.setState(this);
	}
}
class StopState implements State{
	@Override
	public void doAction(Contexts context) {
		// TODO Auto-generated method stub
		System.out.println("stop doing!");
		context.setState(this);
	}
}
class Contexts{
	private  State state;
	public Contexts() {
		state=null;
	}
	public void setState(State state) {
		this.state=state;
	}
	public State getState() {
		return state;
	}
}
public class StatePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contexts contexts=new Contexts();
		StartState startState=new StartState();
		startState.doAction(contexts);
	}

}
