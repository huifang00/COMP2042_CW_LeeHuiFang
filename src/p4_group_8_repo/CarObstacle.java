package p4_group_8_repo;

import javafx.scene.image.Image;

public class CarObstacle extends Obstacle{
	private double speed;	//change the datatype to double
	private Image carobstacleL, carobstacleR;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	//public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
	public CarObstacle(int xpos, int ypos, double speed, double width, double height) {
		carobstacleL = new Image("file:src/p4_group_8_repo/car1Left.png", width, height, true, true); 
		carobstacleR = new Image("file:src/p4_group_8_repo/car1Right.png", width, height, true, true);
		//setImage(new Image(imageLink, w,h, true, true));
		if(speed > 0) {	//moving towards right
			setImage(carobstacleR);
		}
		else {	//moving towards left
			setImage(carobstacleL);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
}
