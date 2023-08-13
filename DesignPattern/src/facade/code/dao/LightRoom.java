package facade.code.dao;

public class LightRoom implements FacadeInterf{
	
	@Override
	public void switchOn() {
		System.out.println("All Lights Dim");		
	}

	@Override
	public void switchOff() {
		System.out.println("All Lights Bright");		
	}

}
