
public class MiniDuck extends Duck {

	public MiniDuck() {
		iFlyBehavior = new FlyWithWings();
		iQuackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("�̴� �����Դϴ�.");
	}
}
