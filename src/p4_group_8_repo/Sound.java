package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
* Pause Class
* Set the soundOn/Off image as a button.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Sound extends Actor{
	/**
	 * The soundOn and soundOff image(s) as button(s).
	 */
	private Image soundOn, soundOff;
	/**
	 * The value to on or mute the background music.
	 */
	private static int i = 0;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Default constructor
	 */
	public Sound() {
		//default constructor
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the soundOn/Off image.
	 * This constructor sets the image of the soundOn/Off button and play/mute the background music.
	 * @param background The class to On/Off the background music.
	 * @param xpos The x-coordinate of the soundOn/Off image.
	 * @param ypos The y-coordinate of the soundOn/Off image.
	 * @param width The width of the soundOn/Off image.
	 * @param height The height of the soundOn/Off image.
	 */
	public Sound(MyStage background, int xpos, int ypos, double width, double height){
		soundOn = new Image("file:src/p4_group_8_repo/soundOn.png", width, height, true, true);
		soundOff = new Image("file:src/p4_group_8_repo/soundOff.png", width, height, true, true);
		setImage(soundOff);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      i++;
			      if(i%2 == 0) {
			    	  setImage(soundOff);
			    	  background.playMusic();
			      }
			      else {
			    	  setImage(soundOn);
			    	  background.stopMusic();
			      }
			}
		}); 
	}
	
	/**
	 * This methods get the value of the sound is played/muted.
	 * @return This returns the value of to play/mute the background music.
	 */
	public boolean getMuted() {
		if(i % 2 == 0)
			return false;
		else 
			return true;
	}
}
