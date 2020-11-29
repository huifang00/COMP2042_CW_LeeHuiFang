package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
* LevelImage Class
* This class set the level image(s) for each level.
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since 	1.4
*/
public class LevelImage extends Actor {
	private Image levelimg;	//the image(s) of level description
	
	/**
	* This is the abstract method from superclass.
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.4
	*/
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * Class constructor specifies and sets the current level, position and size of the level description image.
	 * This constructor sets the image of the level description.
	 * @param level The current level of the player.
	 * @since 1.4
	 */
	public LevelImage(int level) {
		int xpos = 10;
		int ypos = 40;
		double width = 130;
		double height = 130;
		levelimg = new Image("file:src/p4_group_8_repo/Level"+level+".png", width, height, true, true);
		setImage(levelimg);
		setX(xpos);
		setY(ypos);
	}

}
