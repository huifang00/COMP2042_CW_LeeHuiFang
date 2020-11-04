package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class BackgroundImageTest {
	JFXPanel jfxPanel = new JFXPanel();
	BackgroundImage image = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png");
	
	@Test
	public void setgetWidthTest() {
		image.setWidth(10.5);
		double result = image.getWidth();
		assertEquals("setgetWidthTest", 10.5, result, 0);
	}
	
	@Test
	public void setgetHeightTest() {
		image.setHeight(25.76);
		double result = image.getHeight();
		assertEquals("setgetHeightTest", 25.76, result, 0);
	}
}


