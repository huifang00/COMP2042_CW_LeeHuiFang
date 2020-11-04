package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class EndTest {
	JFXPanel jfxPanel = new JFXPanel();
	End end = new End(1, 2, 20, 30);
	
	@Test
	public void constructorTest_X(){
		double x = end.getX();
		assertEquals("constructorTest_X", x, 1, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = end.getY();
		assertEquals("constructorTest_Y", y, 2, 0);
	}
	
	@Test
	public void constructorTest_Width(){
		double width = end.getWidth();
		assertEquals("constructorTest_Width", width, 20, 0);
	}

	@Test
	public void constructorTest_Height(){
		double height = end.getHeight();
		assertEquals("constructorTest_Height", height, 30, 0);
	}
	
	@Test
	public void setEndTest() {
		end.setEnd();
		boolean activated = end.isActivated();
		assertTrue("setEndTest", activated);
	}
	
	@Test
	public void setWidthTest() {
		end.setWidth(12);
		double width = end.getWidth();
		assertEquals("setWidthTest", 12, width, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = end.getWidth();
		assertEquals("getWidthTest", 20, width, 0);
	}
	
	@Test
	public void setHeightTest() {
		end.setHeight(16);
		double height = end.getHeight();
		assertEquals("setHeightTest", 16, height, 0);
	}

	@Test
	public void getHeightTest() {
		double height = end.getHeight();
		assertEquals("getHeightTest", 30, height, 0);
	}
}
