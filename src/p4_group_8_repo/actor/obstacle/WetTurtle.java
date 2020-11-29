package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* WetTurtle Class
* Set the image(s) of Wet turtle as obstacle(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public class WetTurtle extends Obstacle{
	private double speed;	//the speed of wet turtle
	private Image turtle1, turtle2, turtle3, turtle4;	//the image(s) of wet turtle as obstacle(s)
	private boolean sunk = false;	//the value indicates whether the wet turtle goes below the water surface
	
	/**
	* This is the abstract method from superclass.
	* This method allows the wet turtle to perform action(s).
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.0
	*/
	@Override
	public void act(long now) {

		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		} 
		else if (now/900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -120 && speed<0)
			setX(600);
	}
	
	/**
	 * Class constructor specifies and sets the position, speed and size of the wet turtle image.
	 * This constructor sets the image of the wet turtle according to the direction from speed.
	 * @param xpos The x-coordinate of the wet turtle.
	 * @param ypos The y-coordinate of the wet turtle.
	 * @param speed The speed of the wet turtle.
	 * @param width The width of the wet turtle.
	 * @param height The height of the wet turtle.
	 * @since 1.0
	 */
	public WetTurtle(int xpos, int ypos, double speed, double width, double height) {
		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", width, height, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", width, height, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", width, height, true, true);
		turtle4 = new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", width, height, true, true);
		setImage(turtle2);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	
	/**
	 * This method checks whether the wet turtle is on or below water surface.
	 * @return boolean This returns the value on whether the wet turtle is on or below water surface.
	 * @since 1.0
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	/**
	 * This method gets the speed of the wet turtle.
	 * @return double This returns the speed of wet turtle.
	 * @since 1.0.1
	 */
	public double getSpeed() {
		return speed;
	}

}
