package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class ResumeTest {
	JFXPanel jfxPanel = new JFXPanel();
	Resume resume = new Resume(5, 17, 22, 24);
	
	@Test
	public void constructorTest_X(){
		double x = resume.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = resume.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void constructorTest_Width(){
		double width = resume.getWidth();
		assertEquals("constructorTest_Width", width, 22, 0);
	}

	@Test
	public void constructorTest_Height(){
		double height = resume.getHeight();
		assertNotEquals("constructorTest_Height", height, 24, 0);
	}
	
	@Test
	public void setResumeGameTest() {
		resume.setResumeGame(true);
		boolean result = resume.getResumeGame();
		assertTrue("setResumeGameTest", result);
	}
	
	@Test
	public void getResumeGameTest() {
		boolean result = resume.getResumeGame();
		assertFalse("getResumeGameTest", result);
	}
	
	@Test
	public void getWidthTest() {
		double width = resume.getWidth();
		assertEquals("getWidthTest", 22, width, 0);
	}

	@Test
	public void getHeightTest() {
		double height = resume.getHeight();
		assertNotEquals("getHeightTest", 24, height, 0);
	}
}
