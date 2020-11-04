package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class TurtleTest {
	JFXPanel jfxPanel = new JFXPanel();
	Turtle turtle = new Turtle(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = turtle.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = turtle.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void constructorTest_Speed() {
		double speed = turtle.getSpeed();
		assertEquals("constructorTest_Speed", -1, speed, 0);
	}
	
	@Test
	public void constructorTest_Width() {
		double width = turtle.getWidth();
		assertEquals("constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void constructorTest_Height() {
		double height = turtle.getHeight();
		assertEquals("constructorTest_Height", 30, height, 0);
	}
	@Test
	public void getSpeedTest() {
		double speed = turtle.getSpeed();
		assertEquals("getSpeedTest", -1, speed, 0);
	}
	
	@Test
	public void setSpeedTest() {
		turtle.setSpeed(2.2);
		double speed = turtle.getSpeed();
		assertEquals("setSpeedTest", 2.2, speed, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = turtle.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}
	
	@Test
	public void setWidthTest() {
		turtle.setWidth(10.5);
		double width = turtle.getWidth();
		assertEquals("setWidthTest", 10.5, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = turtle.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
	
	@Test
	public void setHeightTest() {
		turtle.setHeight(25.76);
		double height = turtle.getHeight();
		assertEquals("setHeightTest", 25.76, height, 0);
	}
}
