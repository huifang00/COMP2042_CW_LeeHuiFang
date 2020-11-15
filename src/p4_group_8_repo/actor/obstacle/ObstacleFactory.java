package p4_group_8_repo.actor.obstacle;

public class ObstacleFactory{

	//use getObstacle method to get object of type obstacle
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
	      
	      return null;
	   }
}
