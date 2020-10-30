package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private double speed;	//change the speed to double
	//int i = 1;	//not use
	//boolean bool = true;	//not use
	
	public Turtle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w, h, true, true));
		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	/*
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	*/
	
	
}
