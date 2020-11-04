package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class AnimalTest {
	JFXPanel jfxPanel = new JFXPanel();
	Animal animal = new Animal(10, 20, 25.3, 35.1);
	
	@Test
	public  void constructorTest_X() {
		double x = animal.getX();
		assertEquals("constructorTest_X", 10, x, 0);
	}
	
	@Test
	public  void constructorTest_Y() {
		double y = animal.getY();
		assertEquals("constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public  void constructorTest_Width() {
		double width = animal.getWidth();
		assertEquals("constructorTest_Width", 25.3, width, 0);
	}
	
	@Test
	public  void constructorTest_Height() {
		double height = animal.getHeight();
		assertEquals("constructorTest_Height", 35.1, height, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = animal.getWidth();
		assertEquals("getWidthTest", 25.3, width, 0);
	}
	
	@Test
	public void setWidthTest() {
		animal.setWidth(18.9);
		double width = animal.getWidth();
		assertEquals("setWidthTest", 18.9, width, 0);
	}
	
	@Test
	public void getHeightTest() {
		double height = animal.getHeight();
		assertEquals("getHeightTest", 35.1, height, 0);
	}
	
	@Test
	public void setHeightTest() {
		animal.setHeight(22);
		double height = animal.getHeight();
		assertEquals("setHeightTest", 22, height, 0);
	}
	
	@Test
	public void getStopTest() {
		animal.setEnd(5);
		boolean result = animal.getStop();
		assertTrue("getStopTest", result);
	}
	
	@Test
	public void setgetEndTest() {
		animal.setEnd(5);
		int result = animal.getEnd();
		assertEquals("setEndTest", 5, result);
	}
	
	@Test
	public void setgetPointsTest() {
		animal.setPoints(10);
		int result = animal.getPoints();
		assertEquals("setgetPointsTest", 10, result);
	}
	
	@Test
	public void setgetLevelTest() {
		animal.setLevel(2);
		int result = animal.getLevel();
		assertEquals("setgetLevelTest", 2, result);
	}
	
	@Test
	public void setgetDeathTest() {
		animal.setDeath(3);
		int result = animal.getDeath();
		assertEquals("setgetDeath", 3, result);
	}
	
	@Test
	public void setgetChangeScoreTest() {
		animal.setChangeScore(true);
		boolean result = animal.getChangeScore();
		assertTrue("setgetChangeScore", result);
	}
	
	@Test
	public void changeScoreTest() {
		animal.setChangeScore(true);
		boolean result = animal.changeScore();
		assertTrue("changeScoreTest", result);
	}
	
	@Test
	public void setCarDeathTest1() {
		boolean resultCarDeath = animal.setCarDeath(11, true);
		int resultDeath = animal.getDeath();
		assertEquals("resultDeath", resultDeath, 1);
		assertTrue("resultCarDeath", resultCarDeath);
	}
	
	@Test
	public void setCarDeathTest2() {
		animal.setCarDeath(11, true);	//death++
		animal.setCarDeath(11, true);	//death++
		animal.setCarDeath(11, true);	//death++
		boolean resultCarDeath = animal.setCarDeath(11, true);	//death++
		int resultDeath = animal.getDeath();
		assertEquals("resultDeath", resultDeath, 0);
		assertFalse("resultCarDeath", resultCarDeath);
	}
	
	@Test
	public void setWaterDeathTest1() {
		boolean resultWaterDeath = animal.setWaterDeath(11, true);
		int resultDeath = animal.getDeath();
		assertEquals("resultDeath", resultDeath, 1);
		assertTrue("resultWaterDeath", resultWaterDeath);
	}
	
	@Test
	public void setWaterDeathTest2() {
		animal.setWaterDeath(11, true);	//death++
		animal.setWaterDeath(11, true);	//death++
		animal.setWaterDeath(11, true);	//death++
		animal.setWaterDeath(11, true);	//death++
		boolean resultCarDeath = animal.setWaterDeath(11, true);	//death++
		int resultDeath = animal.getDeath();
		assertEquals("resultDeath", resultDeath, 0);
		assertFalse("resultWaterDeath", resultCarDeath);
	}
	
	@Test
	public void intersectionTest() {
		animal.setPoints(100);
		//how to test this?
	}
}
