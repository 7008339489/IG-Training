package factory.code.dao;

public class FactoryMain {

	public static void main(String[] args) {

		Employee emp = FactoryDesign.getEmployee("WEB");
		emp.salary();
	}

}
