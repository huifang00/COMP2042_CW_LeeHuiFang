package p4_group_8_repo.mainfunction;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import p4_group_8_repo.actor.Actor;

/**
* Resume Class
* Set the resume image as a button.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Resume extends Actor{
	/**
	 * The resume image as a button.
	 */
	private Image resume;
	/**
	 * The value to resume the game application.
	 */
	private boolean resumeGame = false;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the resume image.
	 * This constructor sets the image of the resume button.
	 * This constructor defines the action to take when the resume button is clicked.
	 * @param xpos The x-coordinate of the resume image.
	 * @param ypos The y-coordinate of the resume image.
	 * @param width The width of the resume image.
	 * @param height The height of the resume image.
	 */
	public Resume(int xpos, int ypos, double width, double height){
		resume = new Image("file:src/p4_group_8_repo/resume.png", width, height, true, true);
		setImage(resume);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      setResumeGame(true);
			   }
		}); 
			
	}

	/**
	 * This method is get the value to resume the game application.
	 * @return boolean This returns the value to resume the game application.
	 */
	public boolean getResumeGame() {
		return resumeGame;
	}

	/**
	 * This method is set the value to resume the game application.
	 * @param resumeGame The value to resume the game application.
	 */
	public void setResumeGame(boolean resumeGame) {
		this.resumeGame = resumeGame;
	}

}
