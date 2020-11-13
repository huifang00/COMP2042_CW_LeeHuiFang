package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
* Play Class
* Set the play image as a button.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Play extends Actor{
	/**
	 * The play image as a button.
	 */
	private Image play;
	/**
	 * The value to play the game application.
	 */
	private boolean gameplay = false;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the play image.
	 * This constructor sets the image of the play button.
	 * This constructor defines the action to take when the play button is clicked.
	 * @param xpos The x-coordinate of the play image.
	 * @param ypos The y-coordinate of the play image.
	 * @param width The width of the play image.
	 * @param height The height of the play image.
	 */
	public Play(int xpos, int ypos, double width, double height){
		play = new Image("file:src/p4_group_8_repo/play.png", width, height, true, true);
		setImage(play);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      System.out.println("START:"); 
			      setGamePlay(true);
			   }
			}); 
			
	}
	
	/**
	 * This method is get the value to play the game application.
	 * @return boolean This returns the value to play the game application.
	 */
	public boolean getGamePlay() {
		return gameplay;
	}
	
	/**
	 * This method is set the value to play the game application.
	 * @param gameplay The value to play the game application.
	 */
	public void setGamePlay(boolean gameplay) {
		this.gameplay = gameplay;
	}
	
}
