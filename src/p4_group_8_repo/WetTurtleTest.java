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
	public void constructorTest_Width() {
		double width = wetTurtle.getWidth();
		assertEquals("constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void constructorTest_Height() {
		double height = wetTurtle.getHeight();
		assertNotEquals("constructorTest_Height", 30, height, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = wetTurtle.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}

	@Test
	public void getHeightTest() {
		double height = wetTurtle.getHeight();
		assertNotEquals("getHeightTest", 30, height, 0);
	}

}
