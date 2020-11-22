package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
* SnakeObstacle Class
* Set the image(s) of snake as obstacle(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Snake extends Obstacle{
	/**
	 * The speed of snake.
	 */
	private double speed;	//change the datatype to double
	/**
	 * The image(s) of snake as obstacle(s).
	 */
	private Image snakeL, snakeR;
	
	/**
	* This is the abstract method from superclass.
	* This method allows the snake to perform action(s).
	* @param now The timestamp of the current frame given in nanoseconds.
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
	 * Class constructor specifies and sets the position, speed and size of the snake image.
	 * This constructor sets the image of the snake according to the direction from speed.
	 * @param xpos The x-coordinate of the snake.
	 * @param ypos The y-coordinate of the snake.
	 * @param speed The speed of the snake.
	 * @param width The width of the snake.
	 * @param height The height of the snake.
	 */
	public Snake(int xpos, int ypos, double speed, double width, double height) {
		snakeL =  new Image("file:src/p4_group_8_repo/snakeLeft.png", width, height, true, true);
		snakeR =  new Image("file:src/p4_group_8_repo/snakeRight.png", width, height, true, true);
		if(speed > 0) {	//moving towards right
			setImage(snakeR);
		}
		else{ //moving towards left
			setImage(snakeL);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	
}
