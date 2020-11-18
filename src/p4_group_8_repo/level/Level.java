package p4_group_8_repo.level;

import p4_group_8_repo.actor.Animal;

/**
 * Level Interface
 * Interface which contains abstract method must be run in each subclasses.
 * @author  Lee Hui Fang 20125427, hfyhl2
 * @version 1.0
 * @since   2020-12-12
 */
public interface Level {
	public void addLevelImage();
	public void addAnimal();
	public void remove();
	public void setScore(int score);
	public int getScore();
}
