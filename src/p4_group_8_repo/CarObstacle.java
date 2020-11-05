package p4_group_8_repo;

import javafx.scene.image.Image;

public class CarObstacle extends Obstacle{
	private double speed;	//change the datatype to double
	private double width;
	private double height;
	private Image carobstacleL, carobstacleR;
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
	public CarObstacle(int xpos, int ypos, double s, double width, double height) {
		carobstacleL = new Image("file:src/p4_group_8_repo/car1Left.png", width, height, true, true); 
		carobstacleR = new Image("file:src/p4_group_8_repo/car1Right.png", width, height, true, true);
		//setImage(new Image(imageLink, w,h, true, true));
		if(s > 0) {	//moving towards right
			setImage(carobstacleR);
		}
		else {	//moving towards left
			setImage(carobstacleL);
		}
		setX(xpos);
		setY(ypos);
		this.speed = s;
		this.width = width;
		this.height = height;
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
