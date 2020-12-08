package p4_group_8_repo.MVC;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* Controller Class
* A controller for applying MVC pattern. 
* This class is responsible for controlling the way of user interacts with the game interface of frogger application.
* 
*
* @author  	Lee Hui Fang 20125427, hfyhl2
* @since   	1.9
*/
public class Controller {
	@FXML private ImageView background, start, howtoplay, highscore, startIns, sound, pause, instruction;
	@FXML private Label timer;
	private Image background_img, start_img, howtoplay_img, highscore_img, startIns_img, instruction_img;
	private static Image soundOn_img, soundOff_img, pause_img, resume_img;
	private static int soundOnOff = 0;
	private static int pausing = 0;
	private static GameModel gameModel = new GameModel();
	private static Label t;
	
	/**
	 * This method is called when the FXML loader finish loading the FXML document.
	 * @since 1.9
	 */
	public void initialize() {
		//add & set background image
		background_img = new Image("file:src/p4_group_8_repo/iKogsKW_cropped.png");
		background.setImage(background_img);
		
		//add & set start button image
		start_img = new Image("file:src/p4_group_8_repo/play.png");
		start.setImage(start_img);
		
		//add & set instruction image
		howtoplay_img = new Image("file:src/p4_group_8_repo/howtoplay.png");
		howtoplay.setImage(howtoplay_img);
		
		//add & set highscore button image
		highscore_img = new Image("file:src/p4_group_8_repo/highscore.png");
		highscore.setImage(highscore_img);
		
		//add & set text image
		startIns_img = new Image("file:src/p4_group_8_repo/click.png");
		startIns.setImage(startIns_img);
		
		//add & set sound image
		soundOn_img = new Image("file:src/p4_group_8_repo/soundOn.png");
		soundOff_img = new Image("file:src/p4_group_8_repo/soundOff.png");
		sound.setImage(soundOff_img);
		
		//add & set pause/resume image
		pause_img = new Image("file:src/p4_group_8_repo/pause.png");
		resume_img = new Image("file:src/p4_group_8_repo/resume.png");
		
		//add & set instruction button image
		instruction_img = new Image("file:src/p4_group_8_repo/instruction.png");
	}
	
	/**
	 * This method is called when the start/play button is clicked.
	 * @since 1.9
	 */
	@FXML
	public void onStartClicked() {
		System.out.println("START:"); 
		gameModel.setGamePlay(true);
		start.setImage(null);
		howtoplay.setImage(null);
		highscore.setImage(null);
		startIns.setImage(null);
		pause.setImage(pause_img);
		instruction.setImage(instruction_img);
		setTimer(timer);
	}
	
	/**
	 * This method is called when the instruction button is clicked.
	 * @since 1.9
	 */
	@FXML
	public void onInstructionClicked() {
		gameModel.setInsPauseGame(true);
		instruction.setImage(null);
		pause.setImage(null);
		sound.setImage(null);
		gameModel.InstructionDialog();
		if(gameModel.getAlertClose() && instruction.getImage() == null) {
			if(pausing % 2 != 0)
				pausing++;
			if(howtoplay.getImage() == null) {
				pause.setImage(pause_img);
				instruction.setImage(instruction_img);
			}
			if(getMuted()) 
				sound.setImage(soundOn_img);
			else 
				sound.setImage(soundOff_img);
		}
	}
	
	/**
	 * This method is called when the high score button is clicked.
	 * @since 1.9
	 */
	@FXML
	public void onHighscoreClicked() {
		if(!gameModel.getStage().isShowing())
			gameModel.getHighScore();
	}
	
	/**
	 * This method is called when the sound button is clicked.
	 * @since 1.9
	 */
	@FXML
	public void onSoundClicked() {
		soundOnOff++;
		gameModel.setSound(true);
		if(soundOnOff%2 == 0) {
			sound.setImage(soundOff_img);
		}
	    else {
	    	sound.setImage(soundOn_img);
	    }
	}
	
	/**
	 * This method is called when the pause/resume button is clicked.
	 * @since 1.9
	 */
	@FXML
	public void onPauseClicked() {
		pausing++;
		if(pausing%2 == 0) {
			pause.setImage(pause_img);
			gameModel.setPauseGame(false);
			gameModel.setResumeGame(true);
		}
	    else {
	    	gameModel.setPauseGame(true);
	    	gameModel.setResumeGame(false);
	    	pause.setImage(resume_img);
	    }
	}
	
	/**
	 * This methods get the value of the sound is played/muted.
	 * @return This returns the value of to play/mute the background music.
	 * @since 1.9
	 */
	public static boolean getMuted() {
		if(soundOnOff % 2 == 0)
			return false;
		else 
			return true;
	}
	
	/**
	 * This method gets the object of GameModel which is created.
	 * @return GameModel This returns the gamemodel which is created.
	 * @since 1.9
	 */
	public GameModel getGameModel() {
		return gameModel;
	}

	/**
	 * This method returns the value which indicates the pausing status.
	 * @return int This returns the value of pausing status.
	 * @since 1.9
	 */
	public int getPausing() {
		return pausing;
	}
	
	/**
	 * This method gets the value which indicated the sound playing status.
	 * @return int This returns the value of sound playing status.
	 */
	public int getsoundOnOff() {
		return soundOnOff;
	}
	
	/**
	 * This method assigns an object from FXML to another variable typed of Label.
	 * @param timer This is the object from FXML.
	 */
	public static void setTimer(Label timer) {
		t = timer;
	}
	
	/**
	 * This method set the timer in the application.
	 * @param time The game timer in seconds.
	 */
	public void setTime(int time) {
		String text;
		if(time < 10)
			text = "0" + String.valueOf(time);
		else
			text = String.valueOf(time);
		t.setText("TIME: " + text);
	}

}