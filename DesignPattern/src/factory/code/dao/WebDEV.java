package factory.code.dao;

public class WebDEV implements Employee {

	@Override
	public int salary() {
		System.out.println("I am Web Developer");
		return 60000;
	}

}
