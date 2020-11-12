package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Sound;

public class SoundTest {
	JFXPanel jfxPanel = new JFXPanel();
	Sound sound = new Sound(null, 5, 17, 22, 24);
	
	@Test
	public void constructorTest_X(){
		double x = sound.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = sound.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void getMutedTest() {
		boolean result = sound.getMuted();
		assertFalse("getMutedTest",result);
	}

}
