package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.End;

public class EndTest {
	JFXPanel jfxPanel = new JFXPanel();
	End end = new End(1, 2, 20, 30);
	
	@Test
	public void constructorTest_X(){
		double x = end.getX();
		assertEquals("constructorTest_X", x, 1, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = end.getY();
		assertEquals("constructorTest_Y", y, 2, 0);
	}
	
	@Test
	public void setEndTest() {
		end.setEnd();
		boolean activated = end.isActivated();
		assertTrue("setEndTest", activated);
	}
	
	@Test
	public void isActivatedTest() {
		boolean result = end.isActivated();
		assertFalse("isActivatedTest",result);
	}
	
}
