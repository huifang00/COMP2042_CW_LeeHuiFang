package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
* End Class
* Set the image(s) of empty slot and frog placed in the empty slot.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-10-29
*/
public class End extends Actor{
	/**
	 * The value on whether is the slot activated.
	 */
	private boolean activated = false;
	/**
	 * The width of the image.
	 */
	private double width; //cannot declared as global because they are two different image
	/**
	 * The height of the image.
	 */
	private double height;
	/**
	 * The image(s) of empty slot and frog placed in the empty slot.
	 */
	private Image endSlot, endFrog;
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the empty slot image.
	 * This constructor sets the image of the empty slot.
	 * @param xpos The x-coordinate of the empty slot image.
	 * @param ypos The y-coordinate of the empty slot image.
	 * @param width The width of the empty slot image.
	 * @param height The height of the empty slot image.
	 */
	public End(int xpos, int ypos, double width, double height) {
		//endSlot = new Image("file:src/p4_group_8_repo/End.png", 60, 60, true, true);
		endSlot = new Image("file:src/p4_group_8_repo/End.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		setImage(endSlot);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This method is to replaced the empty slot image with a frog image when it is placed in the empty slot.
	 */
	public void setEnd() {	//no need to set the width and height as it is same as the slot
		//endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true);
		endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", width, height, true, true);
		setImage(endFrog);
		activated = true;
	}
	
	/**
	 * This method checks is the slot activated or not activated.
	 * @return The value of the availability of the slot.
	 */
	public boolean isActivated() {
		return activated;
	}
	
}
