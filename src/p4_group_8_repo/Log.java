package p4_group_8_repo;

import javafx.scene.image.Image;

/**
* Log Class
* Set the image(s) of log.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Log extends Actor {
	/**
	 * The speed of log.
	 */
	private double speed;
	/**
	 * The image(s) of log.
	 */
	private Image log1, log2;
	
	/**
	* This is the abstract method from superclass.
	* This method allows the log to perform action(s).
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			//setX(-180);
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
	 */
	//public Log(String imageLink, int size, int xpos, int ypos, double s)
	public Log(int sizeoflog, int xpos, int ypos, double speed, double width, double height) {
		log1 = new Image("file:src/p4_group_8_repo/log3.png", width, height, true, true);
		log2 = new Image("file:src/p4_group_8_repo/logs.png", width, height, true, true);
		if(sizeoflog == 1) {
			setImage(log1);
		}
		else if(sizeoflog == 2) {
			setImage(log2);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	/*
	public boolean getLeft() {
		return speed < 0;
	}
*/
	/**
	 * This method gets the speed of the log.
	 * @return double This returns the speed of log.
	 */
	public double getSpeed() {
		return speed;
	}

}
