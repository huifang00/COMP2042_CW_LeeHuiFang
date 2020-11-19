package p4_group_8_repo.actor.obstacle;

/**
 * ObstacleFactory Class
 * This class is used create the object of Obstacle without exposing the logic to client.
 * This class refer to newly created object using an abstract class.
 * @author  Lee Hui Fang 20125427, hfyhl2 
 * @version 1.0
 * @since   2020-12-12
 */

public class ObstacleFactory{

	/**
	 * This method gets the object of type Obstacle
	 * @param obstacle The name of obstacle need to be created
	 * @param xpos	The x-position of the obstacle
	 * @param ypos	The y-position of the obstacle
	 * @param speed	The speed of the obstacle
	 * @param width	The width of the obstacle
	 * @param height The height of the obstacle
	 * @return	Obstacle This returns the object created based on the name of obstacle given.
	 */
	public Obstacle getObstacle(String obstacle, int xpos, int ypos, double speed, double width, double height){
		if(obstacle == null){
			return null;
		}		
		if(obstacle.equalsIgnoreCase("LOG")){
			return new Log(xpos, ypos, speed, width, height);
		}
		else if(obstacle.equalsIgnoreCase("CAR")){
			return new CarObstacle(xpos, ypos, speed, width, height);
		}
		else if(obstacle.equalsIgnoreCase("TRUCK")){
			return new TruckObstacle(xpos, ypos, speed, width, height);
		}
		else if(obstacle.equalsIgnoreCase("TURTLE")) {
			return new Turtle(xpos, ypos, speed, width, height);
		}
		else if(obstacle.equalsIgnoreCase("WET TURTLE")) {
			return new WetTurtle(xpos, ypos, speed, width, height);
		}
		else if(obstacle.equalsIgnoreCase("SNAKE")) {
			return new Snake(xpos, ypos, speed, width, height);
		}
		return null;
		}
}
