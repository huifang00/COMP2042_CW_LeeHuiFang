package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.WetTurtle;

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
	public void getSpeedTest() {
		double result = wetTurtle.getSpeed();
		assertEquals("getSpeedTest", -1, result, 0);
	}
}
