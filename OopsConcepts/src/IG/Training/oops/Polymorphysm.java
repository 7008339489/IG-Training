package IG.Training.oops;

//Overloading  /Compiletime polymorphysm/Static Polymorphysm
public class Polymorphysm {
	void m1(int i) {
		System.out.println("Single");
	}
	void m1(int i, String s) {
		System.out.println("Double");
	}
}

//Overriding  /Runtime Polymorphysm/Dynamic Polymorphysm
class Runtime {
	void m1() {
		System.out.println("A executed");
	}
}
class SubRuntime extends Runtime {
	void m1() {
		System.out.println("B executed");
	}
}
