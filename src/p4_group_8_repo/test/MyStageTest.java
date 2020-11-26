package p4_group_8_repo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import p4_group_8_repo.actor.Actor;
import p4_group_8_repo.actor.Animal;
import p4_group_8_repo.backgroundfunction.MyStage;
import p4_group_8_repo.backgroundfunction.World;
import p4_group_8_repo.actor.obstacle.CarObstacle;

public class MyStageTest {
	JFXPanel jfxPanel = new JFXPanel();
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,600,800);
	MyStage mystage = new MyStage(root);
	
	@Test
	public void addTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		List<Actor> list = World.getObjects(Actor.class);
		assertEquals("getObjectsTest", 2, list.size());
	}

	@Test
	public void removeTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		mystage.remove(a);
		List<Actor> list = World.getObjects(Actor.class);
		assertEquals("getObjectsTest", 1, list.size());
	}
	
	@Test
	public void getObjectsTest() {
		Actor a = new Animal(1, 2, 3, 4);
		Actor b = new CarObstacle(2, 5, -1, 23, 21);
		mystage.add(a);
		mystage.add(b);
		List<Actor> result = World.getObjects(Actor.class);
		List<Actor> expected = new ArrayList<>();
		expected.add(a);
		expected.add(b);
		assertEquals("getObjectsTest", expected, result);
	}
}
