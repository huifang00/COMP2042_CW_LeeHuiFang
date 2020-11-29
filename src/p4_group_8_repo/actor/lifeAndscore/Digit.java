package p4_group_8_repo.actor.lifeAndscore;

import javafx.scene.image.Image;
import p4_group_8_repo.actor.Actor;

/**
* Digit Class
* Set the image(s) of digit.
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since 	1.0
*/
public class Digit extends Actor{
	private Image im1;	//the image(s) of digit
		
	/**
	* This is the abstract method from superclass.
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.0
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Class constructor specifies and sets the digit to be added, position and size of the digit image.
	 * This constructor sets the image of the digit.
	 * @param n The digit to be added as an image to the interface.
	 * @param xpos The x-coordinate of the digit.
	 * @param ypos The y-coordinate of the digit.
	 * @param width The width of the digit.
	 * @param height The height of the digit.
	 * @since 1.0
	 */
	public Digit(int n, int xpos, int ypos, double width, double height) {
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", width, height, false, true);
		setImage(im1);
		setX(xpos);
		setY(ypos);
	}
	
}
