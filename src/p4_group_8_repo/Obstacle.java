package p4_group_8_repo;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private double speed;	//change the datatype to double
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/*
	 * @param imageLink the location of the obstacle's image
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
