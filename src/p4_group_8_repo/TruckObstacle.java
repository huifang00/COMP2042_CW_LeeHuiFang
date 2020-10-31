package p4_group_8_repo;

import javafx.scene.image.Image;

public class TruckObstacle extends Obstacle {
	private double speed;	//change the datatype to double
	private int w1 = 120;
	private int h1 = 120;
	private int w2 = 200;
	private int h2 = 200;
	private Image truckobstacleL1 = new Image("file:src/p4_group_8_repo/truck1Left.png", w1, h1, true, true), 
				  truckobstacleL2 = new Image("file:src/p4_group_8_repo/truck2Left.png", w2, h2, true, true), 
				  truckobstacleR1 = new Image("file:src/p4_group_8_repo/truck1Right.png", w1, h1, true, true), 
				  truckobstacleR2 = new Image("file:src/p4_group_8_repo/truck2Right.png", w2, h2, true, true);
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public TruckObstacle(int num, int xpos, int ypos, double s) {
		if(s > 0) {	//moving towards right
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
		speed = s;
	}

}
