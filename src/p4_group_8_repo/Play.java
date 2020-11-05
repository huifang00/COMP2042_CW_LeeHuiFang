package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Play extends Actor{

	private double width;
	private double height;
	private Image play;
	private boolean gameplay = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Play(int xpos, int ypos, double width, double height){
		play = new Image("file:src/p4_group_8_repo/play.png", width, height, true, true);
		setImage(play);
		setX(xpos);
		setY(ypos);
		this.width = width;
		this.height = height;
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      System.out.println("START:"); 
			      setGamePlay(true);
			   }
			}); 
			
	}
	
	public void setGamePlay(boolean gameplay) {
		this.gameplay = gameplay;
	}
	
	public boolean getGamePlay() {
		return gameplay;
	}

	@Override
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
