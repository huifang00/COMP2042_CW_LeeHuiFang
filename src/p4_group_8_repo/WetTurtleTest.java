package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class WetTurtleTest {
	JFXPanel jfxPanel = new JFXPanel();
	WetTurtle wetTurtle = new WetTurtle(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = wetTurtle.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = wetTurtle.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void constructorTest_Speed() {
		double speed = wetTurtle.getSpeed();
		assertEquals("constructorTest_Speed", -1, speed, 0);
	}
	
	@Test
	public void constructorTest_Width() {
		double width = wetTurtle.getWidth();
		assertEquals("constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void constructorTest_Height() {
		double height = wetTurtle.getHeight();
		assertEquals("constructorTest_Height", 30, height, 0);
	}
	@Test
	public void getSpeedTest() {
		double speed = wetTurtle.getSpeed();
		assertEquals("getSpeedTest", -1, speed, 0);
	}
	
	@Test
	public void setSpeedTest() {
		wetTurtle.setSpeed(2.2);
		double speed = wetTurtle.getSpeed();
		assertEquals("setSpeedTest", 2.2, speed, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = wetTurtle.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}
	
	@Test
	public void setWidthTest() {
		wetTurtle.setWidth(10.5);
		double width = wetTurtle.getWidth();
		assertEquals("setWidthTest", 10.5, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = wetTurtle.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
	
	@Test
	public void setHeightTest() {
		wetTurtle.setHeight(25.76);
		double height = wetTurtle.getHeight();
		assertEquals("setHeightTest", 25.76, height, 0);
	}
}
