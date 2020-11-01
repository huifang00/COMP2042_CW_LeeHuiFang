package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
		
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * @param imageLink the location of the digit's image
	 */
	//public Digit(int n, int dim, int x, int y)
	public Digit(MyStage background, int n, int x, int y) {	//remove the dimension as parameter since it always fixed to the image
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", 30, 30, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
}
