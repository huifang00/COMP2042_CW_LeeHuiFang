package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class DigitTest {
	JFXPanel jfxPanel = new JFXPanel();
	Digit digit = new Digit(null, 1, 10, 20, 30, 30);
	
	@Test
	public void constructorTest_X() {
		double x = digit.getX();
		assertEquals("constructorTest_X", x, 10, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = digit.getY();
		assertEquals("constructorTest_Y", y, 20, 0);
	}
	
	@Test
	public void setWidthTest() {
		digit.setWidth(10.5);
		double width = digit.getWidth();
		assertEquals("setWidthTest", 10.5, width, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = digit.getWidth();
		assertEquals("getWidthTest", 30, width, 0);
	}
	
	@Test
	public void setHeightTest() {
		digit.setHeight(25.76);
		double height = digit.getHeight();
		assertEquals("setHeightTest", 25.76, height, 0);
	}

	@Test
	public void getHeightTest() {
		double height = digit.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
}
