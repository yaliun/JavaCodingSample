public class SingletonWithDCL {
	
	private volatile static SingletonWithDCL uniqueInstance;
	private int a = 0;
	
	private SingletonWithDCL(){}
	
	public static SingletonWithDCL getInstance(){
		if(uniqueInstance == null){
			synchronized (SingletonWithDCL.class) {
				if(uniqueInstance == null){
					uniqueInstance = new SingletonWithDCL();
				}
			}
		}
		return uniqueInstance;
	}
	
	public int getA(){
		System.out.println("DCL ½Ì±ÛÅæ ÀÏ°æ¿ì ");
		System.out.println(hashCode());
		return a++;
	}
}