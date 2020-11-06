package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	private Image log1, log2;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			//setX(-180);
			setX(-280);
		if (getX()<-300 && speed<0) 
			setX(600);
	}

	//public Log(String imageLink, int size, int xpos, int ypos, double s)
	public Log(int sizeoflog, int xpos, int ypos, double speed, double width, double height) {
		log1 = new Image("file:src/p4_group_8_repo/log3.png", width, height, true, true);
		log2 = new Image("file:src/p4_group_8_repo/logs.png", width, height, true, true);
		if(sizeoflog == 1) {
			setImage(log1);
		}
		else if(sizeoflog == 2) {
			setImage(log2);
		}
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}
	/*
	public boolean getLeft() {
		return speed < 0;
	}
*/
	public double getSpeed() {
		return speed;
	}

}
