package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private double width = 600;
	private double height = 800;
	@Override
	public void act(long now) {
		
	}
	
	/*
	 * @param imageLink the location of the background's image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, width, height, false, true));	//set the preserveRatio to false to fit the image within the bounding box
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
