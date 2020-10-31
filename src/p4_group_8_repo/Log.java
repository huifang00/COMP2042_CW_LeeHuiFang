package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	private int w1 = 300;
	private int h1 = 300;
	private int w2 = 150;
	private int h2 = 150;
	private Image log1 = new Image("file:src/p4_group_8_repo/logs.png", w1, h1, true, true),
				  log2 = new Image("file:src/p4_group_8_repo/log3.png", w2, h2, true, true);
	
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
	/*
	//public Log(String imageLink, int size, int xpos, int ypos, double s)
	public Log(String imageLink, int xpos, int ypos, double s, int w, int h){	//set size to two parameter (easier to set width and height in the future)
		//set the parameter same to each adding photo
		//setImage(new Image(imageLink, size,size, true, true));
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	*/
	public Log(int sizeoflog, int xpos, int ypos, double s) {
		if(sizeoflog == 1) {
			setImage(log1);
		}
		else if(sizeoflog == 2) {
			setImage(log2);
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
