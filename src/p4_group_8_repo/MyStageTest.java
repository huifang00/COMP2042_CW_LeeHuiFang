package p4_group_8_repo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class MyStageTest {
	JFXPanel jfxPanel = new JFXPanel();
	MyStage mystage = new MyStage();
	
	@Test
	public void addTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		List<Actor> list = new ArrayList<>();
		list = mystage.getObjects(Actor.class);
		assertEquals("getObjectsTest", 2, list.size());
	}

	@Test
	public void removeTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		mystage.remove(a);
		List<Actor> list = new ArrayList<>();
		list = mystage.getObjects(Actor.class);
		assertEquals("getObjectsTest", 1, list.size());
	}
	
	@Test
	public void getObjectsTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		List<Actor> result = new ArrayList<>();
		result = mystage.getObjects(Actor.class);
		List<Actor> expected = new ArrayList<>();
		expected.add(a);
		expected.add(b);
		assertEquals("getObjectsTest", expected, result);
	}
}
