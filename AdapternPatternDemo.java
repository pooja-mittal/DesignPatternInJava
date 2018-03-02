
interface MediaPlayer {
	void play(String audioType, String filename);
}

interface AdvancedMediaPlayer {
	void playVLC(String fileName);

	void playMP4(String fileName);
}

class VLC implements AdvancedMediaPlayer {
	public void playVLC(String fileName) {
		System.out.println("vlc is playing file " + fileName);
	}

	public void playMP4(String filename) {

	}
}

class MP4 implements AdvancedMediaPlayer {
	public void playMP4(String fileName) {
		System.out.println("MP4 is playing file " + fileName);
	}

	public void playVLC(String filename) {

	}
}

class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusic;

	MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("VLC")) {
			advancedMusic = new VLC();
		} else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMusic=new MP4();
		}
	}
	
	public void play(String filename, String audioType) {
		if(audioType.equalsIgnoreCase("VLC")) {
			advancedMusic.playVLC(filename);
		} else if(audioType.equalsIgnoreCase("MP4")) {
			advancedMusic.playMP4(filename);
		}
	}
}

class AudioPlayer implements MediaPlayer {
	
	public void play(String filename, String audiotype) {
		
	}
}

public class AdapternPatternDemo {

}
