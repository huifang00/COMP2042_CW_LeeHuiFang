package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.actor.BackgroundImage;

public class BackgroundImageTest {
	JFXPanel jfxPanel = new JFXPanel();
	BackgroundImage image = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png", 600, 800);
	
	@Test
	public void getWidthTest() {
		double result = image.getWidth();
		assertEquals("getWidthTest", 600, result, 0);
	}
	
	@Test
	public void getHeightTest() {
		double result = image.getHeight();
		assertEquals("getHeightTest", 800, result, 0);
	}
}


