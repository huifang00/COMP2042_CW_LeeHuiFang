package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* Log Class
* Set the image(s) and action(s) of log(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public class Log extends Obstacle {
	private double speed;	//the speed of log
	private Image log1, log2;	//the image(s) of log
	
	/**
	* This is the abstract method from superclass.
	* This method allows the log to perform action(s).
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.0
	*/
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-280);
		if (getX()<-300 && speed<0) 
			setX(600);
	}

	/**
	 * Class constructor specifies and sets the size of log, position, speed and size of the log image.
	 * This constructor sets the image of the log according to the direction from speed.
	 * @param xpos The x-coordinate of the log.
	 * @param ypos The y-coordinate of the log.
	 * @param speed The speed of the log.
	 * @param width The width of the log.
	 * @param height The height of the log.
	 * @since 1.0
	 */
	public Log(int xpos, int ypos, double speed, double width, double height) {
		log1 = new Image("file:src/p4_group_8_repo/log3.png", width, height, true, true);
		log2 = new Image("file:src/p4_group_8_repo/logs.png", width, height, true, true);
		if(width == 150) {
			setImage(log1);
		}
		else if(width == 300) {
			setImage(log2);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}

	/**
	 * This method gets the speed of the log.
	 * @return double This returns the speed of log.
	 * @since 1.0.1
	 */
	public double getSpeed() {
		return speed;
	}

}
