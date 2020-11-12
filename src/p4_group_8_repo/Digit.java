package p4_group_8_repo;

import javafx.scene.image.Image;

/**
* Digit Class
* Set the image(s) of digit.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Digit extends Actor{
	//private int dim;
	/**
	 * The image(s) of digit.
	 */
	private Image im1;
		
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Class constructor specifies and sets the digit to be added, position and size of the digit image.
	 * This constructor sets the image of the digit.
	 * @param xpos The x-coordinate of the digit.
	 * @param ypos The y-coordinate of the digit.
	 * @param speed The speed of the digit.
	 * @param width The width of the digit.
	 * @param height The height of the digit.
	 */
	//public Digit(int n, int dim, int x, int y)
	public Digit(int n, int xpos, int ypos, double width, double height) {	//remove the dimension as parameter since it always fixed to the image
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", width, height, false, true);
		setImage(im1);
		setX(xpos);
		setY(ypos);
	}
	
}
