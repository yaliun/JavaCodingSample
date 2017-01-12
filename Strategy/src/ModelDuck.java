
public class ModelDuck extends Duck {

	public ModelDuck() {
		iFlyBehavior = new NoFly();
		iQuackBehavior = new QQuack();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("모형 오리");
	}

}
