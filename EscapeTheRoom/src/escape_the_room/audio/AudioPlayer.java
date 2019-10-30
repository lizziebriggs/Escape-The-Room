package escape_the_room.audio;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	
	private AudioInputStream ais;
	private AudioInputStream dais;
	private Clip clip;
	
	private Boolean isPlaying;
	
	public AudioPlayer(String path) {
		
		// Loads sound clip
		try {
			ais = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Plays sound clip once
	public void playSound() {
		if(clip == null)
			return;
		clip.stop();
		clip.setFramePosition(0);
		clip.start();
		isPlaying = true;
		System.out.println("Sound effect played");
	}
	
	// Plays sound clip on repeat
	public void playSoundLoop() {
		if(clip == null)
			return;
		clip.stop();
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		isPlaying = true;
		System.out.println("Music playing");
	}
	
	// Resumes sound clip from when it was last played
	public void resumeSound() {
		if(!clip.isRunning()) {
			clip.start();
			isPlaying = true;
			System.out.println("Sound effect resumed");
		}
	}
	
	// Resumes sound clip from when it was last played but on loop
	public void resumeSoundLoop() {
		if(!clip.isRunning()) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			isPlaying = true;
			System.out.println("Music resumed");
		}
	}
	
	// Stops sound clip
	public void stopSound() {
		if(clip.isRunning()) {
			clip.stop();
			isPlaying = false;
			System.out.println("Music stopped");
		}
	}
	
	
	// GETTERS AND SETTERS
	
	public Boolean getIsPlaying() {
		return isPlaying;
	}

}
