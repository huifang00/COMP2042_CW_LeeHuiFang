package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/*
	 * @param imageLink the location of the log's image
	 */
	//public Log(String imageLink, int size, int xpos, int ypos, double s)
	public Log(String imageLink, int xpos, int ypos, double s, int w, int h){	//set size to two parameter (easier to set width and height in the future)
		//set the parameter same to each adding photo
		//setImage(new Image(imageLink, size,size, true, true));
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
