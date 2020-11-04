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
		endSlot = new Image("file:src/p4_group_8_repo/End.png", width, height, true, true);
		setX(x);
		setY(y);
		setImage(endSlot);
		this.width = width;
		this.height = height;
	}
	
	
	public void setEnd() {	//no need to set the width and height as it is same as the slot
		endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", width, height, true, true);
		setImage(endFrog);
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
