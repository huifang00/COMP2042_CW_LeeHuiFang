package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class LifeTest {
	JFXPanel jfxPanel = new JFXPanel();
	Life life = new Life(null, 12, 22, 15, 18);
	
	@Test
	public void constructorTest_X() {
		double x = life.getX();
		assertEquals("constructorTest_X", x, 12, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = life.getY();
		assertEquals("constructorTest_Y", y, 22, 0);
	}
	
	@Test
	public void setWidthTest() {
		life.setWidth(11);
		double width = life.getWidth();
		assertEquals("setWidthTest", 11, width, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = life.getWidth();
		assertEquals("getWidthTest", 15, width, 0);
	}
	
	@Test
	public void setHeightTest() {
		life.setHeight(23.4);
		double height = life.getHeight();
		assertEquals("setHeightTest", 23.4, height, 0);
	}

	@Test
	public void getHeightTest() {
		double height = life.getHeight();
		assertEquals("getHeightTest", 18, height, 0);
	}
}
