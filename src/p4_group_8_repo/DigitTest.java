package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class DigitTest {
	JFXPanel jfxPanel = new JFXPanel();
	Digit digit = new Digit(1, 10, 20, 30, 30);
	
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
	public void getWidthTest() {
		double width = digit.getWidth();
		assertEquals("getWidthTest", 30, width, 0);
	}

	@Test
	public void getHeightTest() {
		double height = digit.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
}
