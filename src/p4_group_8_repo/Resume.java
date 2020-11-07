package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Resume extends Actor{

	private Image resume;
	private boolean resumeGame = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Resume() {
		//default constructor
	}
	
	public Resume(int xpos, int ypos, double width, double height){
		resume = new Image("file:src/p4_group_8_repo/resume.png", width, height, true, true);
		setImage(resume);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      setResumeGame(true);
			   }
		}); 
			
	}

	public boolean getResumeGame() {
		return resumeGame;
	}

	public void setResumeGame(boolean resumeGame) {
		this.resumeGame = resumeGame;
	}

}
