package p4_group_8_repo;

import javafx.scene.image.Image;

public abstract class Obstacle extends Actor {
	public abstract void act(long now);
	/*
	private double speed;	//change the datatype to double
	private Image carobstacle1, truckobstacle1, truckobstacle2;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	*/
	/*
	 * @param imageLink the location of the obstacle's image
	 */
	//public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
	/*
	public Obstacle(int xpos, int ypos, double s) {
		//setImage(new Image(imageLink, w,h, true, true));
		if(s > 0) {	//moving towards right
			
		}
		else {	//moving towards left
			
		}
		carobstacle1 = new Image("file:src/p4_group_8_repo/truck1"+"Right.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	*/
}
