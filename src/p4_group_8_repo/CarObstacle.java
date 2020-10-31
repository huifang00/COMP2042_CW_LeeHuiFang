package p4_group_8_repo;

import javafx.scene.image.Image;

public class CarObstacle extends Obstacle{
	private double speed;	//change the datatype to double
	private int w = 50;
	private int h = 50;
	private Image carobstacleL = new Image("file:src/p4_group_8_repo/car1Left.png", w, h, true, true), 
				  carobstacleR = new Image("file:src/p4_group_8_repo/car1Right.png", w, h, true, true);
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
	//public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
	public CarObstacle(int xpos, int ypos, double s) {
		//setImage(new Image(imageLink, w,h, true, true));
		if(s > 0) {	//moving towards right
			setImage(carobstacleR);
		}
		else {	//moving towards left
			setImage(carobstacleL);
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
