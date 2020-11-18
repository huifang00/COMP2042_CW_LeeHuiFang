package p4_group_8_repo.level;

import p4_group_8_repo.actor.Animal;
import p4_group_8_repo.backgroundfunction.MyStage;

/**
 * LevelFactory Class
 * This class is used create the object of Level without exposing the logic to client.
 * This class refer to newly created object using an interface.
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @version 1.0
 * @since   2020-12-12
 */

public class LevelFactory {
	/**
	 * This method gets the object of type Level.
	 * @param level The number of current level.
	 * @param background The stage of the game application where it contain all actors.
	 * @param animal The main character(frog) of the application.
	 * @return Level This returns the object created based on the variable level.
	 */
	public Level getLevel(int level, MyStage background, Animal animal) {
		if(level == 2) {
			return new Level2(background, animal);
		}
		else if(level == 3) {
			return new Level3(background, animal);
		}
		else if(level == 4) {
			return new Level4(background, animal);
		}
		else if(level == 5) {
			return new Level5(background, animal);
		}
		else if(level == 6) {
			return new Level6(background, animal);
		}
		/*
		else if(level == 7) {
			return new Level7(background, animal);
		}
		else if(level == 8) {
			return new Level8(background, animal);
		}
		else if(level == 9) {
			return new Level9(background, animal);
		}
		else if(level == 10) {
			return new Level10(background, animal);
		}
		*/
		return null;
	}
}
