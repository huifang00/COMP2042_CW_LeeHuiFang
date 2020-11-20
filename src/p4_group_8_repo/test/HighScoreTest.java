package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.lifeAndscore.HighScore;

public class HighScoreTest {
	JFXPanel jfxPanel = new JFXPanel();
	HighScore highscore = new HighScore(null, 20, 21, 15.2, 23.1);
	
	@Test
	public void constructorTest_X1() {
		double x = highscore.getX();
		assertEquals("constructorTest_X", x, 20, 0);
	}
	
	@Test
	public void constructorTest_X2() {
		double x = highscore.getX();
		assertNotEquals("constructorTest_X", x, 22, 0);
	}

	@Test
	public void constructorTest_Y1() {
		double y = highscore.getY();
		assertEquals("constructorTest_Y", y, 21, 0);
	}
	
	@Test
	public void constructorTest_Y2() {
		double y = highscore.getY();
		assertNotEquals("constructorTest_Y", y, 21.1, 0);
	}
}
