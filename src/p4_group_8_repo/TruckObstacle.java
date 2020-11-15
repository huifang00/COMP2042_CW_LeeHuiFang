package p4_group_8_repo;

import javafx.scene.image.Image;

/**
* TruckObstacle Class
* Set the image(s) of truck as obstacle(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class TruckObstacle extends Obstacle{
	/**
	 * The speed of truck.
	 */
	private double speed;	//change the datatype to double
	/**
	 * The image(s) of truck as obstacle(s).
	 */
	private Image truckobstacleL1, truckobstacleL2, truckobstacleR1, truckobstacleR2;
	
	/**
	* This is the abstract method from superclass.
	* This method allows the truck to perform action(s).
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		//if (getX() < -50 && speed<0)
		if (getX() < -100 && speed<0)
			setX(600);
	}
	
	/**
	 * Class constructor specifies and sets the position, speed and size of the truck image.
	 * This constructor sets the image of the truck according to the direction from speed.
	 * @param num The number of trailer of truck.
	 * @param xpos The x-coordinate of the truck.
	 * @param ypos The y-coordinate of the truck.
	 * @param speed The speed of the truck.
	 * @param width The width of the truck.
	 * @param height The height of the truck.
	 */
	public TruckObstacle(int xpos, int ypos, double speed, double width, double height) {
		truckobstacleL1 = new Image("file:src/p4_group_8_repo/truck1Left.png", width, height, true, true);
		truckobstacleL2 = new Image("file:src/p4_group_8_repo/truck2Left.png", width, height, true, true);
		truckobstacleR1 = new Image("file:src/p4_group_8_repo/truck1Right.png", width, height, true, true);
		truckobstacleR2 = new Image("file:src/p4_group_8_repo/truck2Right.png", width, height, true, true);
		if(speed > 0) {	//moving towards right
			if(width == 120) {
				setImage(truckobstacleR1);
			}
			else if(width == 200) {
				setImage(truckobstacleR2);
			}
		}
		else{ //moving towards left
			if(width == 120) {
				setImage(truckobstacleL1);
			}
			else if(width == 200) {
				setImage(truckobstacleL2);
			}
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	
}
