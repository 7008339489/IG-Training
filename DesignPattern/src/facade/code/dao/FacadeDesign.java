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
		tv.switchOnTv();
		sound.switchOnSoundSystem();
		light.lightsDim();
	}
	
	public void switchOffMovie() {
		tv.switchOffTv();
		sound.switchOffSounSystem();
		light.lightsBright();
		
	}

}
