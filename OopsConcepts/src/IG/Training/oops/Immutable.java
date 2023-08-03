package IG.Training.oops;

public class Immutable {
	public static void main(String[] args) {
		customImmutable ci1 = new customImmutable(1,"Pritish");
		System.out.println(ci1.getId());
		System.out.println(ci1.getName());
	}
}

final class customImmutable{
	final int id;
	final String name;
	
	public customImmutable(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
}
