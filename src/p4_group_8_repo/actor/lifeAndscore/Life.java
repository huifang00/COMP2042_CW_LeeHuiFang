package p4_group_8_repo.actor.lifeAndscore;

import javafx.scene.image.Image;
import p4_group_8_repo.actor.Actor;

/**
* Life Class
* Set the image(s) of life.
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since 	1.2
*/
public class Life extends Actor{
	private Image life;	//the image(s) of life
		
	/**
	* This is the abstract method from superclass.
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.2
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
	 * @since 1.2
	 */
	public Life(int xpos, int ypos, double width, double height) {
		life = new Image("file:src/p4_group_8_repo/life.png", width, height, true, true);
		setImage(life);
		setX(xpos);
		setY(ypos);
	}

}
