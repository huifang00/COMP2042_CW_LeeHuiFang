package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class InstructionTest {
	JFXPanel jfxPanel = new JFXPanel();
	Instruction instruction = new Instruction("file:src/p4_group_8_repo/instruction.png", 5, 17, 22, 24);
	
	@Test(expected = IllegalArgumentException.class)
	public void ThrowExceptionNoLinkTest() {
		instruction = new Instruction("", 5, 17, 22, 24);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ThrowExceptionSpaceLinkTest1() {
		instruction = new Instruction(" ", 5, 17, 22, 24);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ThrowExceptionSpaceLinkTest2() {
		instruction = new Instruction("abc.png", 5, 17, 22, 24);
	}
	
	@Test(expected = NullPointerException.class)
	public void ThrowExceptionNullLinkTest() {
		instruction = new Instruction(null, 5, 17, 22, 24);
	}
	
	@Test
	public void constructorTest_X(){
		double x = instruction.getX();
		assertEquals("constructorTest_X", x, 5, 0);
	}

	@Test
	public void constructorTest_Y(){
		double y = instruction.getY();
		assertEquals("constructorTest_Y", y, 17, 0);
	}
	
	@Test
	public void constructorTest_Width(){
		double width = instruction.getWidth();
		assertEquals("constructorTest_Width", width, 22, 0);
	}

	@Test
	public void constructorTest_Height(){
		double height = instruction.getHeight();
		assertNotEquals("constructorTest_Height", height, 24, 0);
	}
	
	@Test
	public void getWidthTest() {
		double width = instruction.getWidth();
		assertEquals("getWidthTest", 22, width, 0);
	}

	@Test
	public void getHeightTest() {
		double height = instruction.getHeight();
		assertNotEquals("getHeightTest", 24, height, 0);
	}
}
