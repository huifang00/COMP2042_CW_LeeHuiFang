package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class PauseTest {
	JFXPanel jfxPanel = new JFXPanel();
	Pause pause = new Pause(5, 17, 22, 24);
	
	@Test
	public void constructorTest_X(){
		double x = pause.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = pause.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void constructorTest_Width(){
		double width = pause.getWidth();
		assertEquals("constructorTest_Width", width, 22, 0);
	}

	@Test
	public void constructorTest_Height(){
		double height = pause.getHeight();
		assertNotEquals("constructorTest_Height", height, 24, 0);
	}
	
	@Test
	public void setPauseGameTest() {
		pause.setPauseGame(true);
		boolean result = pause.getPauseGame();
		assertTrue("setPauseGameTest", result);
	}
	
	@Test
	public void getPauseGameTest() {
		boolean result = pause.getPauseGame();
		assertFalse("getPauseGameTest", result);
	}
	
	@Test
	public void getWidthTest() {
		double width = pause.getWidth();
		assertEquals("getWidthTest", 22, width, 0);
	}

	@Test
	public void getHeightTest() {
		double height = pause.getHeight();
		assertNotEquals("getHeightTest", 24, height, 0);
	}
}
