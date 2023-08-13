package facade.code.dao;

public class FacadeDesign {

	Television tv;
	SoundSystem sound;
	LightRoom light;

	public FacadeDesign(Television tv, SoundSystem sound, LightRoom light) {

		this.tv = tv;
		this.sound = sound;
		this.light = light;
	}

	public void switchOnMovie() {
		tv.switchOn();
		sound.switchOn();
		light.switchOn();
	}

	public void switchOffMovie() {
		tv.switchOff();
		sound.switchOff();
		light.switchOff();

	}

}
