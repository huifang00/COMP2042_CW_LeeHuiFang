package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	//private int dim;
	private double width;
	private double height;
	private Image im1;
		
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * @param imageLink the location of the digit's image
	 */
	//public Digit(int n, int dim, int x, int y)
	public Digit(int n, int x, int y, double width, double height) {	//remove the dimension as parameter since it always fixed to the image
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", width, height, true, true);
		setImage(im1);
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
