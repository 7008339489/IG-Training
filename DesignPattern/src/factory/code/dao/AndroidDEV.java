package factory.code.dao;

public class AndroidDEV implements Employee {

	@Override
	public int salary() {
		System.out.println("I am Android Developer");
		return 50000;
	}

}
