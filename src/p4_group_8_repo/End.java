package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	private double width; //cannot declared as global because they are two different image
	private double height;
	private Image endSlot, endFrog;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y, double width, double height) {
		//endSlot = new Image("file:src/p4_group_8_repo/End.png", 60, 60, true, true);
		endSlot = new Image("file:src/p4_group_8_repo/End.png", width, height, true, true);
		setX(x);
		setY(y);
		setImage(endSlot);
		this.width = width;
		this.height = height;
	}
	
	
	public void setEnd() {	//no need to set the width and height as it is same as the slot
		//endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true);
		endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", width, height, true, true);
		setImage(endFrog);
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
}
