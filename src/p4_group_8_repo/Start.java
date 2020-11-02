package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Start extends Actor{

	private int w = 100;
	private int h = 100;
	private Image start = new Image("file:src/p4_group_8_repo/start.png", w, h, true, true);
	private boolean gamestart = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Start() {
		//default constructor
	}
	
	public Start(int xpos, int ypos){
		setImage(start);
		setX(xpos);
		setY(ypos);
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
	
}
