package p4_group_8_repo.level;

import p4_group_8_repo.Main;
import p4_group_8_repo.actor.LevelImage;
import p4_group_8_repo.backgroundfunction.MyStage;
import p4_group_8_repo.actor.obstacle.Obstacle;
import p4_group_8_repo.actor.obstacle.ObstacleFactory;

/**
* Level3 Class
* Class which includes all the actor(s) or images(s) for level 3.
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since 	1.3
*/
public class Level3 extends Level{

	private LevelImage levelImage;
	private MyStage background;
	private ObstacleFactory obstacleFactory = new ObstacleFactory();
	private Obstacle log1, log2, log3, log4, log5, log6, log7,
	turtle1, turtle2, 
	weturtle1, weturtle2, weturtle3, weturtle4, 
	carobstacle1, carobstacle2, carobstacle3, carobstacle4, carobstacle5, 
	truckobstacle1, truckobstacle2, truckobstacle3, truckobstacle4, truckobstacle5, truckobstacle6;
	
	/**
	 * Class constructor which calls the method(s) to create image(s) in the application.
	 * @since 1.3
	 */
	public Level3() {
		this.background = Main.getMyStage();
		addLevelImage();
		addLog();
		addTurtle();
		addCarObstacle();
		addTruckObstacle();
	}
	
	/**
	 * This is the method to add the image of level information.
	 * @since 1.5
	 */
	public void addLevelImage() {
		levelImage = new LevelImage(3);
		background.add(levelImage);
	}

	/**
	 * This is the method to add the image(s) of log.
	 * @since 1.3
	 */
	public void addLog() {
		log1 = obstacleFactory.getObstacle("Log", 0, 166, 2, 150, 150);
    	background.add(log1);
    	log2 = obstacleFactory.getObstacle("Log", 220, 166, 2, 150, 150);
    	background.add(log2);
    	log3 = obstacleFactory.getObstacle("Log", 440, 166, 2, 150, 150);
    	background.add(log3);
    	log4 = obstacleFactory.getObstacle("Log", 0, 276, -2.5, 300, 300);
    	background.add(log4);
    	log5 = obstacleFactory.getObstacle("Log", 400, 276, -2.5, 300, 300);
    	background.add(log5);
    	log6 = obstacleFactory.getObstacle("Log", 50, 329, 3, 150, 150);
    	background.add(log6);
    	log7 = obstacleFactory.getObstacle("Log", 400, 329, 3, 300, 300);
    	background.add(log7);
    }

	/**
	 * This is the method to add the image(s) of wet turtle.
	 * @since 1.3
	 */
    public void addTurtle() {
    	turtle1 = obstacleFactory.getObstacle("Turtle", 500, 376, -2.5, 130, 130);	
    	background.add(turtle1);
    	turtle2 = obstacleFactory.getObstacle("Turtle", 300, 376, -2.5, 130, 130);
    	background.add(turtle2);
    	weturtle1 = obstacleFactory.getObstacle("Wet Turtle", 700, 376, -2.5, 130, 130);
    	background.add(weturtle1);
    	weturtle2 = obstacleFactory.getObstacle("Wet Turtle", 100, 217, 1.5, 130, 130);
    	background.add(weturtle2);
    	weturtle3 = obstacleFactory.getObstacle("Wet Turtle", 400, 217, 1.5, 130, 130);
    	background.add(weturtle3);
    	weturtle4 = obstacleFactory.getObstacle("Wet Turtle", 700, 217, 1.5, 130, 130);
    	background.add(weturtle4);
    	
    }
    
    /**
     * This is the method to add the image(s) of car as obstacle(s).
     * @since 1.3
     */
    public void addCarObstacle() {
    	carobstacle1 = obstacleFactory.getObstacle("Car", 200, 597, -3, 50, 50);
    	background.add(carobstacle1);
    	carobstacle2 = obstacleFactory.getObstacle("Car", 400, 597, -3, 50, 50);
    	background.add(carobstacle2);
    	carobstacle3 = obstacleFactory.getObstacle("Car", 600, 597, -3, 50, 50);
    	background.add(carobstacle3);
    	carobstacle4 = obstacleFactory.getObstacle("Car", 500, 490, -5, 50, 50);
    	background.add(carobstacle4);
    	carobstacle5 = obstacleFactory.getObstacle("Car", 300, 540, 1, 50, 50);
    	background.add(carobstacle5);
    }

    /**
     * This is the method to add the image(s) of truck as obstacle(s).
     * @since 1.3
     */
    public void addTruckObstacle() {
    	truckobstacle1 = obstacleFactory.getObstacle("Truck", 0, 649, 1, 120, 120);
    	background.add(truckobstacle1);
    	truckobstacle2 = obstacleFactory.getObstacle("Truck", 300, 649, 1, 120, 120);
    	background.add(truckobstacle2);
    	truckobstacle3 = obstacleFactory.getObstacle("Truck", 600, 649, 1, 120, 120);
    	background.add(truckobstacle3);
    	truckobstacle4 = obstacleFactory.getObstacle("Truck", 0, 540, 1, 200, 200);
    	background.add(truckobstacle4);
    	truckobstacle5 = obstacleFactory.getObstacle("Truck", 500, 540, 1, 200, 200);
    	background.add(truckobstacle5);
    	truckobstacle6 = obstacleFactory.getObstacle("Truck", 150, 490, -5, 120, 120);
    	background.add(truckobstacle6);
    }
    
}

