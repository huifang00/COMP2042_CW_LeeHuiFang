package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	private Image endSlot = new Image("file:src/p4_group_8_repo/End.png", 60, 60, true, true),
				  endFrog = new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true);
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(endSlot);
	}
	
	public void setEnd() {
		setImage(endFrog);
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
