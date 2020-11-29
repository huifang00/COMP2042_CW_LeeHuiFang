package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* CarObstacle Class
* Set the image(s) of car as obstacle(s).
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since 	1.1
*/
public class CarObstacle extends Obstacle{
	private double speed;	//the speed of car
	private Image carobstacleL, carobstacleR;	//the image(s) of car as obstacle(s).
	
	/**
	* This is the abstract method from superclass.
	* This method allows the car to perform action(s).
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.1
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
	 * @since 1.1
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
