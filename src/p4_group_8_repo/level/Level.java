package p4_group_8_repo.level;

import p4_group_8_repo.Main;
import p4_group_8_repo.actor.Actor;
import p4_group_8_repo.actor.End;
import p4_group_8_repo.backgroundfunction.MyStage;
import p4_group_8_repo.backgroundfunction.World;

/**
 * Level Interface
 * Interface which contains abstract method must be run in each subclasses.
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @since	1.5
 */
public abstract class Level {
	private int score = 0;
	private static End end1, end2, end3, end4, end5;
	/**
	 * This is the method to add the image of level information.
	 * @since 1.5
	 */
	public abstract void addLevelImage();
	
	/**
     * This is the method to set the score which player get for current level.
     * @param score The score which player get for current level.
     * @since 1.5
     */
	public void setScore(int score) {
		this.score = score;
	};
	
	/**
     * This is the method to get the score of current level which player achieved.
     * @return int This returns the score of current level which player achieved.
     * @since 1.5
     */
	public int getScore() {
		return score;
	}
	
	/**
     * This is the static method to remove the image(s) of previous level.
     * @since 1.5
     */
	public static void remove() {
	    while(!World.getObjects(Actor.class).isEmpty()) {
	    	Main.getMyStage().remove(World.getObjects(Actor.class).get(0));
	    }
	}
	
	/**
     * This is the method to add the image(s) of empty slot.
     * @since 1.1
     */
    public static void addEnd() {
    	MyStage background = Main.getMyStage();
    	end1 = new End(13, 96, 60, 60);
    	background.add(end1);
    	end2 = new End(141, 96, 60, 60);
    	background.add(end2);
    	end3 = new End(141 + 141-13, 96, 60, 60);
    	background.add(end3);
    	end4 = new End(141 + 141-13+141-13+1, 96, 60, 60);
    	background.add(end4);
    	end5 = new End(141 + 141-13+141-13+141-13+3, 96, 60, 60);
    	background.add(end5);
    }
}
