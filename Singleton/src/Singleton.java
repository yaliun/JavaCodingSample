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
		System.out.println("±âº» ½Ì±ÛÅæ ÀÏ°æ¿ì ");
		System.out.println(hashCode());
		return a++;
	}
}