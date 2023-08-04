package factory.code.dao;

public class FactoryDesign {
	
	static Employee e = null;
	
	public static Employee getEmployee(String type) {

		if (type.trim().equals("ANDROID")) {
			e = new AndroidDEV();
			return e;
			}
		else if(type.trim().equals("WEB")) {
			e = new WebDEV();
			return e;
		}
		else {
			return e;
		}
	}

}
//Creational - 5
//Structual* - 7
//behaviour - 11