package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import p4_group_8_repo.actor.Animal;
import p4_group_8_repo.backgroundfunction.MyStage;
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
	MyStage background = new MyStage(root);
	Animal animal = new Animal(300, 679.8+(13.3333333*2), 40, 40);
	LevelFactory levelFactory = new LevelFactory();
	
	@Test
	public void getLevel2Test1() {
		Level level = levelFactory.getLevel(2, background, animal);
		assertEquals("getLevel2Test1", Level2.class, level.getClass());
	}
	
	@Test
	public void getLevel2Test2() {
		Level level = levelFactory.getLevel(3, background, animal);
		assertNotEquals("getLevel2Test2", Level2.class, level.getClass());
	}

	@Test
	public void getLevel3Test1() {
		Level level = levelFactory.getLevel(3, background, animal);
		assertEquals("getLevel2Test1", Level3.class, level.getClass());
	}
	
	@Test
	public void getLevel3Test2() {
		Level level = levelFactory.getLevel(4, background, animal);
		assertNotEquals("getLevel2Test2", Level3.class, level.getClass());
	}

	@Test
	public void getLevel4Test1() {
		Level level = levelFactory.getLevel(4, background, animal);
		assertEquals("getLevel4Test1", Level4.class, level.getClass());
	}
	
	@Test
	public void getLevel4Test2() {
		Level level = levelFactory.getLevel(5, background, animal);
		assertNotEquals("getLevel4Test2", Level4.class, level.getClass());
	}

	@Test
	public void getLevel5Test1() {
		Level level = levelFactory.getLevel(5, background, animal);
		assertEquals("getLevel5Test1", Level5.class, level.getClass());
	}
	
	@Test
	public void getLevel5Test2() {
		Level level = levelFactory.getLevel(6, background, animal);
		assertNotEquals("getLevel5Test2", Level5.class, level.getClass());
	}

	@Test
	public void getLevel6Test1() {
		Level level = levelFactory.getLevel(6, background, animal);
		assertEquals("getLevel6Test1", Level6.class, level.getClass());
	}
	
	@Test
	public void getLevel6Test2() {
		Level level = levelFactory.getLevel(7, background, animal);
		assertNotEquals("getLevel6Test2", Level6.class, level.getClass());
	}

	@Test
	public void getLevel7Test1() {
		Level level = levelFactory.getLevel(7, background, animal);
		assertEquals("getLevel7Test1", Level7.class, level.getClass());
	}
	
	@Test
	public void getLevel7Test2() {
		Level level = levelFactory.getLevel(8, background, animal);
		assertNotEquals("getLevel7Test2", Level7.class, level.getClass());
	}

	@Test
	public void getLevel8Test1() {
		Level level = levelFactory.getLevel(8, background, animal);
		assertEquals("getLevel8Test1", Level8.class, level.getClass());
	}
	
	@Test
	public void getLevel8Test2() {
		Level level = levelFactory.getLevel(9, background, animal);
		assertNotEquals("getLevel8Test2", Level8.class, level.getClass());
	}

	@Test
	public void getLevel9Test1() {
		Level level = levelFactory.getLevel(9, background, animal);
		assertEquals("getLevel9Test1", Level9.class, level.getClass());
	}
	
	@Test
	public void getLevel9Test2() {
		Level level = levelFactory.getLevel(10, background, animal);
		assertNotEquals("getLevel9Test2", Level9.class, level.getClass());
	}

	@Test
	public void getLevel10Test1() {
		Level level = levelFactory.getLevel(10, background, animal);
		assertEquals("getLevel10Test1", Level10.class, level.getClass());
	}
	
	@Test
	public void getLevel10Test2() {
		Level level = levelFactory.getLevel(2, background, animal);
		assertNotEquals("getLevel10Test2", Level10.class, level.getClass());
	}
	
	@Test
	public void getLevelNotExistTest() {
		Level level = levelFactory.getLevel(12, background, animal);
		assertEquals("getLevelNotExistTest", null, level);
	}
}
