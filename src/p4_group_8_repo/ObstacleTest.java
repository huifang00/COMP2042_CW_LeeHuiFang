package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;

public class ObstacleTest {
	JFXPanel jfxPanel = new JFXPanel();
	Obstacle car = new CarObstacle(10, 20, -1, 25, 30);
	Obstacle truck = new TruckObstacle(1, 10, 20, -1, 25, 30);
	
	@Test
	public void Car_constructorTest_X() {
		double x = car.getX();
		assertEquals("Car_constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void Car_constructorTest_Y() {
		double y = car.getY();
		assertEquals("Car_constructorTest_Y", 20, y, 0);
	}

	@Test
	public void Car_constructorTest_Width() {
		double width = car.getWidth();
		assertEquals("Car_constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void Car_constructorTest_Height() {
		double height = car.getHeight();
		assertEquals("Car_constructorTest_Height", 30, height, 0);
	}
	
	@Test
	public void Car_getWidthTest() {
		double width = car.getWidth();
		assertEquals("Car_getWidthTest", 25, width, 0);
	}
	
	@Test
	public void Car_getHeightTest() {
		double height = car.getHeight();
		assertEquals("Car_getHeightTest", 30, height, 0);
	}

	@Test
	public void Truck_constructorTest_X() {
		double x = truck.getX();
		assertEquals("Truck_constructorTest_X", 10, x, 0);
	}
	
	@Test
	public void Truck_constructorTest_Y() {
		double y = truck.getY();
		assertEquals("Truck_constructorTest_Y", 20, y, 0);
	}
	
	@Test
	public void Truck_constructorTest_Width() {
		double width = truck.getWidth();
		assertEquals("Truck_constructorTest_Width", 25, width, 0);
	}
	
	@Test
	public void Truck_constructorTest_Height() {
		double height = truck.getHeight();
		assertEquals("Truck_constructorTest_Height", 30, height, 0);
	}
	
	@Test
	public void Truck_getWidthTest() {
		double width = truck.getWidth();
		assertEquals("Truck_getWidthTest", 25, width, 0);
	}
	
	
	@Test
	public void Truck_getHeightTest() {
		double height = truck.getHeight();
		assertEquals("Truck_getHeightTest", 30, height, 0);
	}

}
