package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.obstacle.TruckObstacle;

public class TruckObstacleTest {
	JFXPanel jfxPanel = new JFXPanel();
	TruckObstacle truck = new TruckObstacle(10, 20, -1, 25, 30);
	
	@Test
	public void constructorTest_X() {
		double x = truck.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = truck.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}

}
