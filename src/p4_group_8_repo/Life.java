package p4_group_8_repo;

import javafx.scene.image.Image;

public class Life extends Actor{
	private double width;
	private double height;
	private Image life;
		
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Life(MyStage background, int x, int y, double width, double height) {	//remove the dimension as parameter since it always fixed to the image
		life = new Image("file:src/p4_group_8_repo/life.png", width, height, true, true);
		setImage(life);
		setX(x);
		setY(y);
		this.width = width;
		this.height = height;
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
