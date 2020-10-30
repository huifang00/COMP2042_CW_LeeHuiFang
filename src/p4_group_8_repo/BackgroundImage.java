package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	/*
	 * @param imageLink the location of the background's image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, false, true));	//set the preserveRatio to false to fit the image within the bounding box
		
	}

}
