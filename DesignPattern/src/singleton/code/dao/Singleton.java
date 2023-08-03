package singleton.code.dao;

public class Singleton {

	private Singleton() {
	}

	private static Singleton vSingleton = null;

	public static Singleton mSingleton() {
		if (vSingleton == null) {
			vSingleton = new Singleton();
		} 
			return vSingleton;
	}
}
