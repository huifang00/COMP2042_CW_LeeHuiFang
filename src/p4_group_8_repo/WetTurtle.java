package p4_group_8_repo;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	private double speed;	//change the datatype to double
	private double width;
	private double height;
	private Image turtle1, turtle2, turtle3, turtle4;
	//int i = 1;
	//boolean bool = true;
	boolean sunk = false;
	
	@Override
	public void act(long now) {

		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		} 
		else if (now/900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	//public WetTurtle(String imageLink, int xpos, int ypos, double s, int w, int h) {
	public WetTurtle(int xpos, int ypos, double speed, double width, double height) {
		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", width, height, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", width, height, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", width, height, true, true);
		turtle4 = new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", width, height, true, true);
		setImage(turtle2);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public boolean isSunk() {
		return sunk;
	}
	
	public boolean getLeft() {
		return speed < 0;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
