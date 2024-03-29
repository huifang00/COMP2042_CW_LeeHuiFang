package p4_group_8_repo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import p4_group_8_repo.actor.Animal;
import p4_group_8_repo.actor.obstacle.Obstacle;
import p4_group_8_repo.actor.obstacle.ObstacleFactory;
import p4_group_8_repo.backgroundfunction.MyStage;


public class AnimalTest{
	JFXPanel jfxPanel = new JFXPanel();
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,600,800);
	MyStage background = new MyStage(root);
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
	public void getIntersectObjectsTest() {
		MyStage myWorld = new MyStage(root);
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
	
}
