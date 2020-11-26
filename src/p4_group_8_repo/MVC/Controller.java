package p4_group_8_repo.MVC;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import p4_group_8_repo.backgroundfunction.MyStage;

public class Controller {
	@FXML private ImageView background, start, howtoplay, highscore, startIns, sound, pause, instruction;
	private Image background_img, start_img, howtoplay_img, highscore_img, startIns_img, instruction_img;
	private static Image soundOn_img, soundOff_img, pause_img, resume_img;
	public static int soundOnOff = 0;
	public static int pausing = 0;
	private static GameModel gameModel = new GameModel();
	
	public void initialize() {
		background_img = new Image("file:src/p4_group_8_repo/iKogsKW_cropped.png");
		background.setImage(background_img);
		start_img = new Image("file:src/p4_group_8_repo/play.png");
		start.setImage(start_img);
		howtoplay_img = new Image("file:src/p4_group_8_repo/howtoplay.png");
		howtoplay.setImage(howtoplay_img);
		highscore_img = new Image("file:src/p4_group_8_repo/highscore.png");
		highscore.setImage(highscore_img);
		startIns_img = new Image("file:src/p4_group_8_repo/click.png");
		startIns.setImage(startIns_img);
		soundOn_img = new Image("file:src/p4_group_8_repo/soundOn.png");
		soundOff_img = new Image("file:src/p4_group_8_repo/soundOff.png");
		sound.setImage(soundOff_img);
		pause_img = new Image("file:src/p4_group_8_repo/pause.png");
		resume_img = new Image("file:src/p4_group_8_repo/resume.png");
		instruction_img = new Image("file:src/p4_group_8_repo/instruction.png");
		
	}
	
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
	}
	
	@FXML
	public void onInstructionClicked() {
		gameModel.setInsPauseGame(true);
		instruction.setImage(null);
		pause.setImage(null);
		//sound.setImage(null);
		gameModel.InstructionDialog();
		if(gameModel.getAlertClose() && howtoplay.getImage() == null) {
			if(pausing % 2 != 0)
				pausing++;
			pause.setImage(pause_img);
			instruction.setImage(instruction_img);
			if(getMuted())
				sound.setImage(soundOn_img);
			else
				sound.setImage(soundOff_img);
		}
	}
	
	@FXML
	public void onHighscoreClicked() {
		if(!gameModel.getStage().isShowing())
			gameModel.getHighScore();
	}
	
	@FXML
	public void onSoundClicked() {
		soundOnOff++;
		if(soundOnOff%2 == 0) {
			sound.setImage(soundOff_img);
			if(pausing%2 == 0) 
				MyStage.playMusic();
		}
	    else {
	    	sound.setImage(soundOn_img);
	    	MyStage.stopMusic();
	    }
	}
	
	@FXML
	public void onPauseClicked() {
		//pausing = 1;
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
	 */
	public static boolean getMuted() {
		if(soundOnOff % 2 == 0)
			return false;
		else 
			return true;
	}
	
	public static GameModel getGameModel() {
		return gameModel;
	}

}
