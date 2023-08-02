package IG.Training.oops;

public class Abstraction {
	public static void main(String[] args) {
		Shape s1=new Circle1();  
		s1.draw();  
		Shape s2=new Rectangle();  
		s2.draw();
	}
}

abstract class Shape {
	abstract void draw();
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("drawing rectangle");
	}
}
class Circle1 extends Shape {
	void draw() {
		System.out.println("drawing circle");
	}
}
