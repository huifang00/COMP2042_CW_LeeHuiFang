package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Turtle;

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
	public void getSpeedTest() {
		double result = turtle.getSpeed();
		assertEquals("getSpeedTest", -1, result, 0);
	}
}
