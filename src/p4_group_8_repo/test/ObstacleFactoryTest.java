package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.obstacle.CarObstacle;
import p4_group_8_repo.actor.obstacle.Log;
import p4_group_8_repo.actor.obstacle.Obstacle;
import p4_group_8_repo.actor.obstacle.ObstacleFactory;
import p4_group_8_repo.actor.obstacle.Snake;
import p4_group_8_repo.actor.obstacle.TruckObstacle;
import p4_group_8_repo.actor.obstacle.Turtle;
import p4_group_8_repo.actor.obstacle.WetTurtle;

public class ObstacleFactoryTest {
	
	JFXPanel jfxPanel = new JFXPanel();
	ObstacleFactory obstacleFactory = new ObstacleFactory();
	
	@Test
	public void getObstacleNullTest() {
		Obstacle obstacle = obstacleFactory.getObstacle("", 20, 30, 2, 30, 40);
		assertEquals("getObstacleNullTest", null, obstacle);
	}
	
	@Test
	public void getObstacleLogTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Log", 20, 30, 2, 30, 40);
		assertEquals("getObstacleCarTest1", Log.class, obstacle.getClass());
	}

	@Test
	public void getObstacleLogTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Car", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleCarTest2", Log.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleCarTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Car", 20, 30, 2, 30, 40);
		assertEquals("getObstacleCarTest1", CarObstacle.class, obstacle.getClass());
	}

	@Test
	public void getObstacleCarTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Truck", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleCarTest2", CarObstacle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleTruckTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Truck", 20, 30, 2, 30, 40);
		assertEquals("getObstacleTruckTest1", TruckObstacle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleTruckTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Car", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleTruckTest2", TruckObstacle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleTurtleTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Turtle", 20, 30, 2, 30, 40);
		assertEquals("getObstacleTurtleTest1", Turtle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleTurtleTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Wet Turtle", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleTurtleTest2", Turtle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleWetTurtleTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Wet Turtle", 20, 30, 2, 30, 40);
		assertEquals("getObstacleTurtleTest1", WetTurtle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleWetTurtleTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Turtle", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleWetTurtleTest2", WetTurtle.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleSnakeTest1() {
		Obstacle obstacle = obstacleFactory.getObstacle("Snake", 20, 30, 2, 30, 40);
		assertEquals("getObstacleTurtleTest1", Snake.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleSnakeTest2() {
		Obstacle obstacle = obstacleFactory.getObstacle("Wet Turtle", 20, 30, 2, 30, 40);
		assertNotEquals("getObstacleSnakeTest2", Snake.class, obstacle.getClass());
	}
	
	@Test
	public void getObstacleStringNotExistTest() {
		Obstacle obstacle = obstacleFactory.getObstacle("Obstacle", 20, 30, 2, 30, 40);
		assertEquals("getObstacleNullTest", null, obstacle);
	}
	
}
