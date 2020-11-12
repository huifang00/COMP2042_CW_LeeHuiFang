package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
* Pause Class
* Set the pause image as a button.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Pause extends Actor{
	/**
	 * The pause image as a button.
	 */
	private Image pause;
	/**
	 * The value to pause the game application.
	 */
	private boolean pauseGame = false;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the pause image.
	 * This constructor sets the image of the pause button.
	 * This constructor defines the action to take when the pause button is clicked.
	 * @param xpos The x-coordinate of the pause image.
	 * @param ypos The y-coordinate of the pause image.
	 * @param width The width of the pause image.
	 * @param height The height of the pause image.
	 */
	public Pause(int xpos, int ypos, double width, double height){
		pause = new Image("file:src/p4_group_8_repo/pause.png", width, height, true, true);
		setImage(pause);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      setPauseGame(true);
			   }
		}); 
			
	}

	/**
	 * This method is get the value to pause the game application.
	 * @return This returns the value to pause the game application.
	 */
	public boolean getPauseGame() {
		return pauseGame;
	}

	/**
	 * This method is set the value to pause the game application.
	 * @param The value to pause the game application.
	 */
	public void setPauseGame(boolean pauseGame) {
		this.pauseGame = pauseGame;
	}

}
