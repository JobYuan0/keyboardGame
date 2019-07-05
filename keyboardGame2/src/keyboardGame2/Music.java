package keyboardGame2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Music {
	/*public final static File[] music={
			new File(images.class.getResource("/music/童话镇.wav").getPath()),
			new File(images.class.getResource("/music/PLANET.wav").getPath()),
			new File(images.class.getResource("/music/讲真的.wav").getPath()),
			new File(images.class.getResource("/music/卡路里.wav").getPath()),
			new File(images.class.getResource("/music/你打不过我吧.wav").getPath()),
			new File(images.class.getResource("/music/凉凉.wav").getPath()),
			new File(images.class.getResource("/music/boom.wav").getPath())
	};*/
	public final static URL[] music={
			images.class.getResource("/music/WestWorld.wav"),
			images.class.getResource("/music/ThroughTheYears.wav"),
			images.class.getResource("/music/Mind.wav"),
			images.class.getResource("/music/LOVELETTER TO YOU.wav"),
			images.class.getResource("/music/Frogs and Toads.wav"),
			images.class.getResource("/music/boom.wav")
	};
	public static AudioClip ac1,ac2;
	public Music(){
		/*try {
		   url=Music.music[6].toURL();
		} catch (MalformedURLException e) {
		e.printStackTrace();}*/
		ac1= Applet.newAudioClip(music[5]);
		ac1.play();
	}
	public Music(int i){
		/*try {
		   url=Music.music[i-1].toURL();
		} catch (MalformedURLException e) {
		e.printStackTrace();} */
		if(MyFrame.bgm){
			ac2.stop();
		}
		ac2= Applet.newAudioClip(music[i-1]);
		ac2.loop();
	}
	public static void clear(){
		if(MyFrame.bgm)
			ac2.stop();
	}
}
