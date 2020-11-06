package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class TruckObstacleTest {
	JFXPanel jfxPanel = new JFXPanel();
	TruckObstacle truck = new TruckObstacle(1, 10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = truck.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = truck.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void constructorTest_Width() {
		double width = truck.getWidth();
		assertEquals("constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void constructorTest_Height() {
		double height = truck.getHeight();
		assertEquals("constructorTest_Height", 30, height, 0);
	}

	@Test
	public void getWidthTest() {
		double width = truck.getWidth();
		assertEquals("getWidthTest", 25, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = truck.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
	
}
