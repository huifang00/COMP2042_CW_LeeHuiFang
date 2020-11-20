package p4_group_8_repo.actor.lifeAndscore;

import javafx.scene.image.Image;
import p4_group_8_repo.actor.Actor;

/**
* Life Class
* Set the image(s) of life.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Life extends Actor{
	/**
	 * The image of life
	 */
	private Image life;
		
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies the position and size of lige image.
	 * @param xpos The x-coordinate of the life image.
	 * @param ypos The y-coordinate of the life image.
	 * @param width The width of the life image.
	 * @param height The height of the life image.
	 */
	public Life(int xpos, int ypos, double width, double height) {	//remove the dimension as parameter since it always fixed to the image
		life = new Image("file:src/p4_group_8_repo/life.png", width, height, true, true);
		setImage(life);
		setX(xpos);
		setY(ypos);
	}

}
