package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Animal;

public class AnimalTest {
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

	
	@Test
	public void intersectionTest() {
		animal.setPoints(100);
		//how to test this?
	}
}
