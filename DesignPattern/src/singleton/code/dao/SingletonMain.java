package singleton.code.dao;

public class SingletonMain {

	public static void main(String[] args) {

		Singleton s = Singleton.mSingleton();
		System.out.println(s.hashCode());
		
		Singleton s1 = Singleton.mSingleton();
		System.out.println(s1.hashCode());
	}

}
