package p4_group_8_repo.level;

/**
 * LevelFactory Class
 * This class is used create the object of Level without exposing the logic to client.
 * This class refer to newly created object using an interface.
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @since	1.5
 */

public class LevelFactory {
	/**
	 * This method gets the object of type Level.
	 * @param level The number of current level.
	 * @return Level This returns the object created based on the variable level.
	 * @since 1.5
	 */
	public Level getLevel(int level) {
		if(level == 2) {
			return new Level2();	//return object of Level2
		}
		else if(level == 3) {
			return new Level3();	//return object of Level3
		}
		else if(level == 4) {
			return new Level4();	//return object of Level4
		}
		else if(level == 5) {
			return new Level5();	//return object of Level5
		}
		else if(level == 6) {
			return new Level6();	//return object of Level6
		}
		else if(level == 7) {
			return new Level7();	//return object of Level7
		}
		else if(level == 8) {
			return new Level8();	//return object of Level8
		}
		else if(level == 9) {
			return new Level9();	//return object of Level9
		}
		else if(level == 10) {
			return new Level10();	//return object of Level10
		}
		return null;	//return null
	}
}
