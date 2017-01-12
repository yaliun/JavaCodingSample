
public class Main {
	public static void main(String[] args){
	
		Duck miniDuck = new MiniDuck();
		
		miniDuck.display();
		miniDuck.performfly();
		miniDuck.performQuack();
		
		
		System.out.println("================");
		Duck modelDuck = new ModelDuck();
		
		modelDuck.display();
		modelDuck.performfly();
		modelDuck.performQuack();
		
		
		System.out.println("================");
		
		modelDuck.setFlyBehavior(new FlyWithWings());
		modelDuck.setQuackBehavior(new Quack());
		
		modelDuck.display();
		modelDuck.performfly();
		modelDuck.performQuack();

	}
}
