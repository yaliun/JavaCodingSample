
public abstract class Duck {
	
	IFlyBehavior iFlyBehavior;
	IQuackBehavior iQuackBehavior;
	
	public Duck(){
	}
	
	public abstract void display();
	
	public void performfly(){
		iFlyBehavior.fly();
	}
	
	public void performQuack(){
		iQuackBehavior.quack();
	}
	
	public void setFlyBehavior(IFlyBehavior fb){
		this.iFlyBehavior = fb;
	}
	
	public void setQuackBehavior(IQuackBehavior qb){
		this.iQuackBehavior = qb;
	}
}
