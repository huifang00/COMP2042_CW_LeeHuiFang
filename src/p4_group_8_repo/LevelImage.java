package p4_group_8_repo;

import javafx.scene.image.Image;

public class LevelImage extends Actor {

	private Image level1, level2, level3;
	@Override
	public void act(long now) {
		
	}
	
	/*
	 * @param imageLink the location of the background's image
	 */
	public LevelImage(int level, int xpos, int ypos, double width, double height) {
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
	}

}
