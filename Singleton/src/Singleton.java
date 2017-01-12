import java.util.concurrent.SynchronousQueue;

public class Singleton {

	private static Singleton uniqueInstance;
	private int a = 0;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public int getA(){
		System.out.println("�⺻ �̱��� �ϰ�� ");
		System.out.println(hashCode());
		return a++;
	}
}