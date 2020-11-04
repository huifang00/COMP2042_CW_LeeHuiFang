package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class CarObstacleTest {
	JFXPanel jfxPanel = new JFXPanel();
	CarObstacle car = new CarObstacle(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = car.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = car.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void constructorTest_Speed() {
		double speed = car.getSpeed();
		assertEquals("constructorTest_Speed", -1, speed, 0);
	}
	
	@Test
	public void constructorTest_Width() {
		double width = car.getWidth();
		assertEquals("constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void constructorTest_Height() {
		double height = car.getHeight();
		assertEquals("constructorTest_Height", 30, height, 0);
	}
	@Test
	public void getSpeedTest() {
		double speed = car.getSpeed();
		assertEquals("getSpeedTest", -1, speed, 0);
	}
	
	@Test
	public void setSpeedTest() {
		car.setSpeed(2.2);
		double speed = car.getSpeed();
		assertEquals("setSpeedTest", 2.2, speed, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = car.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}
	
	@Test
	public void setWidthTest() {
		car.setWidth(10.5);
		double width = car.getWidth();
		assertEquals("setWidthTest", 10.5, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = car.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
	
	@Test
	public void setHeightTest() {
		car.setHeight(25.76);
		double height = car.getHeight();
		assertEquals("setHeightTest", 25.76, height, 0);
	}
	
}
