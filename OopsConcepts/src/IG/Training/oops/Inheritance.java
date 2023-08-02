package IG.Training.oops;

public class Inheritance {
	public static void main(String[] args) {
		//Single Inheritance
		B b = new B();
		b.m1();
		b.m2();
		
		//Multilevel Inheritance
		C c = new C();
		c.m1();
		c.m2();
		c.m3();
		
		//Hirichical Inheritance
		D d = new D();
		d.m4();
		d.m1();
		//d.m2(); (CE - The method m2() is undefined for the type D)
	}
}

class A {
	void m1() {
		System.out.println("m1 executed");
	}
}
//Single Inheritance
class B extends A {
	void m2() {
		System.out.println("m2 executed");
	}
}
//Multilevel Inheritance
class C extends B {
	void m3() {
		System.out.println("m3 executed");
	}
}
//Hirichical Inheritance
class D extends A {
	void m4() {
		System.out.println("m4 executed");
	}
}
