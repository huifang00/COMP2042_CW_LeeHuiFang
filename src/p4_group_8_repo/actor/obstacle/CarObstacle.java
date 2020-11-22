package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* CarObstacle Class
* Set the image(s) of car as obstacle(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class CarObstacle extends Obstacle{
	/**
	 * The speed of car.
	 */
	private double speed;	//changed the datatype to double
	/**
	 * The image(s) of car as obstacle(s).
	 */
	private Image carobstacleL, carobstacleR;
	
	/**
	* This is the abstract method from superclass.
	* This method allows the car to perform action(s).
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	
	/**
	 * Class constructor specifies and sets the position, speed and size of the car image.
	 * This constructor sets the image of the car according to the direction from speed.
	 * @param xpos The x-coordinate of the car.
	 * @param ypos The y-coordinate of the car.
	 * @param speed The speed of the car.
	 * @param width The width of the car.
	 * @param height The height of the car.
	 */
	public CarObstacle(int xpos, int ypos, double speed, double width, double height) {
		carobstacleL = new Image("file:src/p4_group_8_repo/car1Left.png", width, height, true, true); 
		carobstacleR = new Image("file:src/p4_group_8_repo/car1Right.png", width, height, true, true);
		if(speed > 0) {	//moving towards right
			setImage(carobstacleR);
		}
		else {	//moving towards left
			setImage(carobstacleL);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
}
