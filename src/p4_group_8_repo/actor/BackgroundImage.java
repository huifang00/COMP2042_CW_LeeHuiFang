package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
* BackgroundImage Class
* Set the background image of the application.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class BackgroundImage extends Actor{

	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * Class constructor specifies and sets the location and size of background image.
	 * @param imageLink The file location of the background image.
	 * @param width The width of the background image.
	 * @param height The height of the background image.
	 */
	public BackgroundImage(String imageLink, double width, double height) {
		setImage(new Image(imageLink, width, height, false, true));	//set the preserveRatio to false to fit the image within the bounding box
	}

}
