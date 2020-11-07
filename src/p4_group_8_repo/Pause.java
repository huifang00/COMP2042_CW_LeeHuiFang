package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Pause extends Actor{

	private Image pause;
	private boolean pauseGame = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Pause() {
		//default constructor
	}
	
	public Pause(int xpos, int ypos, double width, double height){
		pause = new Image("file:src/p4_group_8_repo/pause.png", width, height, true, true);
		setImage(pause);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      setPauseGame(true);
			   }
		}); 
			
	}

	public boolean getPauseGame() {
		return pauseGame;
	}

	public void setPauseGame(boolean pauseGame) {
		this.pauseGame = pauseGame;
	}

}
