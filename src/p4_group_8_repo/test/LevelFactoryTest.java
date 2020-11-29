package p4_group_8_repo.test;

import static org.junit.Assert.*;
import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.level.Level;
import p4_group_8_repo.level.Level10;
import p4_group_8_repo.level.Level2;
import p4_group_8_repo.level.Level3;
import p4_group_8_repo.level.Level4;
import p4_group_8_repo.level.Level5;
import p4_group_8_repo.level.Level6;
import p4_group_8_repo.level.Level7;
import p4_group_8_repo.level.Level8;
import p4_group_8_repo.level.Level9;
import p4_group_8_repo.level.LevelFactory;

public class LevelFactoryTest {
	
	JFXPanel jfxPanel = new JFXPanel();
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,600,800);
	LevelFactory levelFactory = new LevelFactory();
	
	@Test
	public void getLevel2Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(2);
		assertEquals("getLevel2Test1", Level2.class, level.getClass());
	}
	
	@Test
	public void getLevel2Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(3);
		assertNotEquals("getLevel2Test2", Level2.class, level.getClass());
	}

	@Test
	public void getLevel3Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(3);
		assertEquals("getLevel2Test1", Level3.class, level.getClass());
	}
	
	@Test
	public void getLevel3Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(4);
		assertNotEquals("getLevel2Test2", Level3.class, level.getClass());
	}

	@Test
	public void getLevel4Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(4);
		assertEquals("getLevel4Test1", Level4.class, level.getClass());
	}
	
	@Test
	public void getLevel4Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(5);
		assertNotEquals("getLevel4Test2", Level4.class, level.getClass());
	}

	@Test
	public void getLevel5Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(5);
		assertEquals("getLevel5Test1", Level5.class, level.getClass());
	}
	
	@Test
	public void getLevel5Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(6);
		assertNotEquals("getLevel5Test2", Level5.class, level.getClass());
	}

	@Test
	public void getLevel6Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(6);
		assertEquals("getLevel6Test1", Level6.class, level.getClass());
	}
	
	@Test
	public void getLevel6Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(7);
		assertNotEquals("getLevel6Test2", Level6.class, level.getClass());
	}

	@Test
	public void getLevel7Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(7);
		assertEquals("getLevel7Test1", Level7.class, level.getClass());
	}
	
	@Test
	public void getLevel7Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(8);
		assertNotEquals("getLevel7Test2", Level7.class, level.getClass());
	}

	@Test
	public void getLevel8Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(8);
		assertEquals("getLevel8Test1", Level8.class, level.getClass());
	}
	
	@Test
	public void getLevel8Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(9);
		assertNotEquals("getLevel8Test2", Level8.class, level.getClass());
	}

	@Test
	public void getLevel9Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(9);
		assertEquals("getLevel9Test1", Level9.class, level.getClass());
	}
	
	@Test
	public void getLevel9Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(10);
		assertNotEquals("getLevel9Test2", Level9.class, level.getClass());
	}

	@Test
	public void getLevel10Test1() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(10);
		assertEquals("getLevel10Test1", Level10.class, level.getClass());
	}
	
	@Test
	public void getLevel10Test2() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(2);
		assertNotEquals("getLevel10Test2", Level10.class, level.getClass());
	}
	
	@Test
	public void getLevelNotExistTest() {
		Main.setMyStage(root);
		Level level = levelFactory.getLevel(12);
		assertEquals("getLevelNotExistTest", null, level);
	}
}
