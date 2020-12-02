package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* Turtle Class
* Set the image(s) and action(s) of turtle(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since	 1.0
*/
public class Turtle extends Obstacle{
	private double speed;	//the speed of turtle
	private Image turtle1, turtle2, turtle3;	//the image(s) of turtle as obstacle(s)
	
	/**
	* This is the abstract method from superclass.
	* This method allows the turtle to perform action(s).
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.0
	*/
	@Override
	public void act(long now) {

		if (now/900000000  % 3 ==0) {
			setImage(turtle2);			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);			
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtle3);
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -120 && speed<0)
			setX(600);
	}
	
	/**
	 * Class constructor specifies and sets the position, speed and size of the turtle image.
	 * This constructor sets the image of the turtle according to the direction from speed.
	 * @param xpos The x-coordinate of the turtle.
	 * @param ypos The y-coordinate of the turtle.
	 * @param speed The speed of the turtle.
	 * @param width The width of the turtle.
	 * @param height The height of the turtle.
	 * @since 1.0
	 */
	public Turtle(int xpos, int ypos, double speed, double width, double height) {
		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", width, height, true, true);
 		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2.png", width, height, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", width, height, true, true);
		setImage(turtle2);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	
	/**
	 * This method gets the speed of the turtle.
	 * @return double This returns the speed of turtle.
	 * @since 1.0.1
	 */
	public double getSpeed() {
		return speed;
	}

}
