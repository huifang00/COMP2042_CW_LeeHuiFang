package p4_group_8_repo.backgroundfunction;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage Class
 * Class play or stop the background music 
 * 
 * @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * This is the method to call the music file, create an Media object and play the background music.
	 */
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * This is the method to stop on playing the background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}		

}
