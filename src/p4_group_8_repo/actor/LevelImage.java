package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
* LevelImage Class
* Set the level image(s).
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class LevelImage extends Actor {
	/**
	 * The image(s) of level description.
	 */
	private Image levelimg;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * Class constructor specifies and sets the current level, position and size of the level description image.
	 * This constructor sets the image of the level description.
	 * @param level The current level of the player.
	 * @param xpos The x-coordinate of the level description image.
	 * @param ypos The y-coordinate of the level description image.
	 * @param width The width of the level description image.
	 * @param height The height of the level description image.
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
		/*
		level1 = new Image("file:src/p4_group_8_repo/Level1.png", width, height, true, true);
		level2 = new Image("file:src/p4_group_8_repo/Level2.png", width, height, true, true);
		level3 = new Image("file:src/p4_group_8_repo/Level3.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		if(level == 1)
			setImage(level1);
		else if(level == 2)
			setImage(level2);
		else if(level == 3)
			setImage(level3);
		*/
	}

}
