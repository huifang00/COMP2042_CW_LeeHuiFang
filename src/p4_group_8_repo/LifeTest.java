package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Life;

public class LifeTest {
	JFXPanel jfxPanel = new JFXPanel();
	Life life = new Life(12, 22, 15, 18);
	
	@Test
	public void constructorTest_X() {
		double x = life.getX();
		assertEquals("constructorTest_X", x, 12, 0);
	}
	
	@Test
	public void constructorTest_Y() {
		double y = life.getY();
		assertEquals("constructorTest_Y", y, 22, 0);
	}
	
}
