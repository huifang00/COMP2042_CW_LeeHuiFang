package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Start extends Actor{

	private double width;
	private double height;
	private Image start;
	private boolean gamestart = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Start() {
		//default constructor
	}
	
	public Start(int xpos, int ypos, double width, double height){
		start = new Image("file:src/p4_group_8_repo/start.png", width, height, true, true);
		setImage(start);
		setX(xpos);
		setY(ypos);
		this.width = width;
		this.height = height;
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      System.out.println("START:"); 
			      setGameStart(true);
			   }
			}); 
			
	}
	
	public void setGameStart(boolean gamestart) {
		this.gamestart = gamestart;
	}
	
	public boolean getGameStart() {
		return gamestart;
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
