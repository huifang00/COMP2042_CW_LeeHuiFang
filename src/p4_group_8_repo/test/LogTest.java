package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.obstacle.Log;

public class LogTest {
	JFXPanel jfxPanel = new JFXPanel();
	Log log = new Log(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = log.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = log.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}

	@Test
	public void getSpeedTest() {
		double result = log.getSpeed();
		assertEquals("getSpeedTest", -1, result, 0);
	}
}
