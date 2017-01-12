public class SingletonWithSynchronized {
	private static SingletonWithSynchronized uniqueInstance;
	private int a = 0;
	
	private SingletonWithSynchronized(){}
	
	public static synchronized SingletonWithSynchronized getInstance(){
		if(uniqueInstance == null) uniqueInstance = new SingletonWithSynchronized();
		return uniqueInstance;
	}
	
	public int getA(){
		System.out.println("µø±‚»≠ ΩÃ±€≈Ê ¿œ∞ÊøÏ ");
		System.out.println(hashCode());
		return a++;
	}
}