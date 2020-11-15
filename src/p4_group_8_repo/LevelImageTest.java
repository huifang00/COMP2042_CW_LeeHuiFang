package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class LevelImageTest {
	JFXPanel jfxPanel = new JFXPanel();
	LevelImage levelimage = new LevelImage(1, 3, 23, 12, 14);
	
	@Test
	public void constructorTest_X1() {
		double x = levelimage.getX();
		assertEquals("constructorTest_X", 3, x, 0);
	}
	
	@Test
	public void constructorTest_X2() {
		double x = levelimage.getX();
		assertNotEquals("constructorTest_X", x, 22, 0);
	}

	@Test
	public void constructorTest_Y1() {
		double y = levelimage.getY();
		assertEquals("constructorTest_Y", y, 23, 0);
	}
	
	@Test
	public void constructorTest_Y2() {
		double y = levelimage.getY();
		assertNotEquals("constructorTest_Y", y, 21.1, 0);
	}
}
