package p4_group_8_repo;

import javafx.scene.image.Image;

public class TruckObstacle extends Obstacle {
	private double speed;	//change the datatype to double
	private double width;
	private double height;
	private Image truckobstacleL1, truckobstacleL2, truckobstacleR1, truckobstacleR2;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public TruckObstacle(int num, int xpos, int ypos, double speed, double width, double height) {
		truckobstacleL1 = new Image("file:src/p4_group_8_repo/truck1Left.png", width, height, true, true);
		truckobstacleL2 = new Image("file:src/p4_group_8_repo/truck2Left.png", width, height, true, true);
		truckobstacleR1 = new Image("file:src/p4_group_8_repo/truck1Right.png", width, height, true, true);
		truckobstacleR2 = new Image("file:src/p4_group_8_repo/truck2Right.png", width, height, true, true);
		if(speed > 0) {	//moving towards right
			if(num == 1) {
				setImage(truckobstacleR1);
			}
			else if(num == 2) {
				setImage(truckobstacleR2);
			}
		}
		else{ //moving towards left
			if(num == 1) {
				setImage(truckobstacleL1);
			}
			else if(num == 2) {
				setImage(truckobstacleL2);
			}
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	
}
