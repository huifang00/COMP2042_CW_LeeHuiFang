package p4_group_8_repo.level;

import p4_group_8_repo.Main;
import p4_group_8_repo.actor.Actor;
import p4_group_8_repo.backgroundfunction.World;

/**
 * Level Interface
 * Interface which contains abstract method must be run in each subclasses.
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @since	1.5
 */
public interface Level {
	/**
	 * This is the method to add the image of level information.
	 * @since 1.5
	 */
	public void addLevelImage();
	
	/**
     * This is the method to add the image of frog as the main character on the game interface of the application.
     * @since 1.5
     */

	public void addAnimal();
	
	/**
     * This is the method to set the score which player get for current level.
     * @param score The score which player get for current level.
     * @since 1.5
     */
	public void setScore(int score);
	
	/**
     * This is the method to get the score of current level which player achieved.
     * @return int This returns the score of current level which player achieved.
     * @since 1.5
     */
	public int getScore();
	
	/**
     * This is the static method to remove the image(s) of previous level.
     * @since 1.5
     */
	public static void remove() {
	    while(!World.getObjects(Actor.class).isEmpty()) {
	    	Main.getMyStage().remove(World.getObjects(Actor.class).get(0));
	    }
	}
}
