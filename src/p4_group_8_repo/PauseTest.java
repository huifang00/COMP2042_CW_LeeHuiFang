package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Pause;

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

}
