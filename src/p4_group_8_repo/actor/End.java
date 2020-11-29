package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
* End Class
* This class set the image(s) of empty slot and frog placed in the empty slot.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public class End extends Actor{
	private boolean activated = false;	//the value on whether is the slot activated
	private double width; 	//the width of the image
	private double height;	//the height of the image
	private Image endSlot, endFrog;		//the image(s) of empty slot and frog placed in the empty slot
	
	/**
	* This is the abstract method from superclass.
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since   1.0
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
	 * @since   1.0
	 */
	public End(int xpos, int ypos, double width, double height) {
		endSlot = new Image("file:src/p4_group_8_repo/End.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		setImage(endSlot);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This method is to replaced the empty slot image with a frog image when it is placed in the empty slot.
	 * @since   1.0
	 */
	public void setEnd() {
		endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", width, height, true, true);
		setImage(endFrog);
		activated = true;
	}
	
	/**
	 * This method checks is the slot activated or not activated.
	 * @return The value of the availability of the slot.
	 * @since   1.0
	 */
	public boolean isActivated() {
		return activated;
	}
	
}
