package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Play;

public class PlayTest {
	JFXPanel jfxPanel = new JFXPanel();
	Play play = new Play(5, 17, 22, 24);
	
	@Test
	public void constructorTest_X(){
		double x = play.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = play.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void setGamePlayTest() {
		play.setGamePlay(true);
		boolean result = play.getGamePlay();
		assertTrue("setGamePlayTest", result);
	}
	
	@Test
	public void getGamePlayTest() {
		boolean result = play.getGamePlay();
		assertFalse("getGamePlayTest", result);
	}
	

}
