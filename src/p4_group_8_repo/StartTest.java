package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class StartTest {
	JFXPanel jfxPanel = new JFXPanel();
	Start start = new Start(5, 17, 22, 24);
	
	@Test
	public void constructorTest_X(){
		double x = start.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = start.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void constructorTest_Width(){
		double width = start.getWidth();
		assertEquals("constructorTest_Width", width, 22, 0);
	}

	@Test
	public void constructorTest_Height(){
		double height = start.getHeight();
		assertEquals("constructorTest_Height", height, 24, 0);
	}
	
	@Test
	public void setGameStartTest() {
		start.setGameStart(true);
		boolean result = start.getGameStart();
		assertTrue("setGameStartTest", result);
	}
	
	@Test
	public void getGameStartTest() {
		boolean result = start.getGameStart();
		assertFalse("getGameStartTest", result);
	}
	
	@Test
	public void setWidthTest() {
		start.setWidth(15);
		double width = start.getWidth();
		assertEquals("setWidthTest", 15, width, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = start.getWidth();
		assertEquals("getWidthTest", 22, width, 0);
	}
	
	@Test
	public void setHeightTest() {
		start.setHeight(17);
		double height = start.getHeight();
		assertEquals("setHeightTest", 17, height, 0);
	}

	@Test
	public void getHeightTest() {
		double height = start.getHeight();
		assertEquals("getHeightTest", 24, height, 0);
	}
}
