package facade.code.dao;

public class facadeMain {

	public static void main(String[] args) {

		FacadeDesign fd = new FacadeDesign(new Television(), new SoundSystem(), new LightRoom());
		fd.switchOnMovie();

		fd.switchOffMovie();

	}

}
