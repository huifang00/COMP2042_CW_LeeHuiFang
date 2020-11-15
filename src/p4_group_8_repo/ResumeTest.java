package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Resume;

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

}
