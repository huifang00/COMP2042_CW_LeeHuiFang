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
	public void getWidthTest() {
		double width = car.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = car.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
	
}
