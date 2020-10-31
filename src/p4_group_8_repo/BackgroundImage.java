package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private int w = 600;
	private int h = 800;
	@Override
	public void act(long now) {
		
		
	}
	
	/*
	 * @param imageLink the location of the background's image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, w, h, false, true));	//set the preserveRatio to false to fit the image within the bounding box
		
	}

}
