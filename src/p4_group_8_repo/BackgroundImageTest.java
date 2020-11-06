package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class BackgroundImageTest {
	JFXPanel jfxPanel = new JFXPanel();
	BackgroundImage image = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png", 600, 800);
	
	@Test
	public void getWidthTest() {
		double result = image.getWidth();
		assertEquals("getWidthTest", 10.5, result, 0);
	}
	
	@Test
	public void setgetHeightTest() {
		double result = image.getHeight();
		assertEquals("getHeightTest", 25.76, result, 0);
	}
}


