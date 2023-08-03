package IG.Training.oops;

public class Singleton {
	
	private static final Singleton vSingleton =  null;
	
	public static Singleton mSingleton() {
		if(vSingleton==null) {
			return new Singleton();
		}
		else {
			return vSingleton;
		}
	}
}
