package p4_group_8_repo.backgroundfunction;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage Class
 * Class play or stop the background music 
 * 
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @since 	1.0
 */
public class MyStage extends World{

	/**
	 * Constructor to invoke the super class constructor.
	 * @param root The variable of Border Pane which is created using the Scene Builder.
	 * @since 1.0.1
	 */
	public MyStage(BorderPane root) {
		super(root);
	}
	
	private static MediaPlayer mediaPlayer;
	@Override
	
	/**
	 * This is the abstract method from superclass.
	 * This method allows the the media to be played and paused when the application is running.
	 * @since 1.0
	 */
	public void act(long now) {
		
	}
	
	/**
	 * This is the method to call the music file, create an Media object and play the background music.
	 * @since 1.0
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
	 * @since 1.0
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}		

}
