package p4_group_8_repo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.Animal;
import p4_group_8_repo.backgroundfunction.MyStage;
import p4_group_8_repo.actor.obstacle.Obstacle;
import p4_group_8_repo.actor.obstacle.ObstacleFactory;
import p4_group_8_repo.actor.obstacle.TruckObstacle;

public class AnimalTest{
	JFXPanel jfxPanel = new JFXPanel();
	Animal animal = new Animal(10, 20, 25.3, 35.1);
	
	@Test
	public  void constructorTest_X() {
		double x = animal.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public  void constructorTest_Y() {
		double y = animal.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void getStopTest1() {
		animal.setEnd(5);
		boolean result = animal.getStop();
		assertTrue("getStopTest", result);
	}
	
	@Test
	public void getStopTest2() {
		animal.setEnd(2);
		boolean result = animal.getStop();
		assertFalse("getStopTest", result);
	}
	
	@Test
	public void setgetPointsTest() {
		animal.setPoints(10);
		int result = animal.getPoints();
		assertEquals("setgetPointsTest", 10, result);
	}
	
	@Test
	public void changeLifeTest() {
		boolean result = animal.changeLife();
		assertFalse("changeLifeTest", result);
	}

	//Test on the method in abstract class
	@Test
	public void getWidthTest1() {
		double result = animal.getWidth();
		assertEquals("getWidthTest", 25, result, 0);
	}
	
	@Test
	public void getWidthTest2() {
		double result = animal.getWidth();
		assertNotEquals("getWidthTest", 25.3, result, 0);
	}
	
	@Test
	public void getHeightTest() {
		double result = animal.getHeight();
		assertEquals("getHeightTest", 21, result, 0);
	}
	
	@Test
	public void getHeightTest2() {
		double result = animal.getHeight();
		assertNotEquals("getHeightTest", 35.1, result, 0);
	}
	
	@Test
	public void getWorldTest() {
		boolean result = false;
		MyStage myWorld = new MyStage();
		myWorld.add(animal);
		if(animal.getWorld() != null)
			result = true;
		assertTrue("getWorldTest", result);
	}
	
	@Test
	public void getIntersectObjectsTest() {
		MyStage myWorld = new MyStage();
		ObstacleFactory obstacleFactory = new ObstacleFactory();
		Obstacle car1 = obstacleFactory.getObstacle("Car", 4, 4, 1, 30, 30);
		Obstacle car2 = obstacleFactory.getObstacle("Car", 4, 4, -1, 30, 30);
		myWorld.add(animal);
		myWorld.add(car1);
		myWorld.add(car2);
		List<Obstacle> list = new ArrayList<>();
		list = animal.getIntersectingObjects(Obstacle.class);
		int result = list.size();
		assertEquals("getIntersectObjectsTest", 2, result);
	}
	
	@Test
	public void getIntersectObjectTest() {
		MyStage myWorld = new MyStage();
		ObstacleFactory obstacleFactory = new ObstacleFactory();
		Obstacle truck1 = obstacleFactory.getObstacle("Truck", 42, 34, -1, 30, 30);
		Obstacle truck2 = obstacleFactory.getObstacle("Truck", 31, 24, 3, 30, 30);
		myWorld.add(animal);
		myWorld.add(truck1);
		myWorld.add(truck2);
		List<Obstacle> list = new ArrayList<>();
		list = animal.getIntersectingObjects(Obstacle.class);
		TruckObstacle obj;
		obj = animal.getOneIntersectingObject(TruckObstacle.class);
		assertEquals("getIntersectObjectTest", list.get(0), obj);
	}
}
