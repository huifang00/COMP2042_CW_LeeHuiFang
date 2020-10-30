package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	Image im2;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * @param imageLink the location of the digit's image
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
	/* new method need to implement more to remove image
	public Digit(Image image, int n, int dim, int x, int y) {
		setImage(null);
		setVisible(false);
		setX(x);
		setY(y);
	}
	*/
}
