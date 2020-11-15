package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.obstacle.CarObstacle;

public class CarObstacleTest {
	JFXPanel jfxPanel = new JFXPanel();
	CarObstacle car = new CarObstacle(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = car.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = car.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}

}
