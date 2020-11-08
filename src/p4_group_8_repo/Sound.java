package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Sound extends Actor{

	private Image soundOn, soundOff;
	private static int i = 0;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Sound() {
		//default constructor
	}
	
	public Sound(MyStage background, int xpos, int ypos, double width, double height){
		soundOn = new Image("file:src/p4_group_8_repo/soundOn.png", width, height, true, true);
		soundOff = new Image("file:src/p4_group_8_repo/soundOff.png", width, height, true, true);
		setImage(soundOff);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      i++;
			      if(i%2 == 0) {
			    	  setImage(soundOff);
			    	  background.playMusic();
			      }
			      else {
			    	  setImage(soundOn);
			    	  background.stopMusic();
			      }
			}
		}); 
	}
}
