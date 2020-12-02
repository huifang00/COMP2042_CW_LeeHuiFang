package p4_group_8_repo.MVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * GameModel Class 
 * This class contains all the logic of frogger application that is not contained in a view or a controller.
 * 
 * 
 * @author  	Lee Hui Fang 20125427, hfyhl2
 * @since   	1.9
 */
public class GameModel {

	private boolean InspauseGame = false;
	private int instructionPage = 1;
	private boolean gameplay = false;
	private boolean resumeGame = false;
	private boolean pauseGame = false;
	private static Stage new_stage = new Stage();
	private boolean alertClose = false;
	private boolean sound = false;
	
	/**
	 * This method gets the value to play the game application.
	 * @return boolean This returns the value to play the game application.
	 * @since 1.9
	 */
	public boolean getGamePlay() {
		return gameplay;
	}
	
	/**
	 * This method sets the value to play the game application.
	 * @param gameplay The value to play the game application.
	 * @since 1.9
	 */
	public void setGamePlay(boolean gameplay) {
		this.gameplay = gameplay;
	}
	
	/**
	 * This method displays the instruction dialog.
	 * @since 1.9
	 */
	public void InstructionDialog() {
		setAlertClose(false);
		String instruction = "";
		Alert alert = new Alert(AlertType.NONE);
		alert.getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
		alert.setTitle("INSTRUCTION");

		//get the stage
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		//add a custom icon
		stage.getIcons().add(new Image(this.getClass().getResource("../smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		
		//print Instruction
		switch(instructionPage) {
			case 1: instruction = "Help the frog \ud83d\udc38 to cross the traffic and river\n"
					+ "Help the frog to the empty slot\n\n"
					+ "1. Use the key W to move the frog up \u2b06\n"
					+ "2. Use the key S to move the frog down \u2b07\n"
					+ "3. Use the key A to move the frog left \u2b05\n"
					+ "4. Use the key D to move the frog right \u27a1";break;
			case 2: instruction = "1. Avoid the moving car(s) \ud83d\ude97 and truck(s) \ud83d\ude9a\n\n"
					+ "2. Logs of different lengths is to help the frog to cross the river\n"
					+ "   Jump on the log to avoid the frog from falling into river\n\n"
					+ "3. Step on the red turtles \ud83d\udc22 to avoid the frog from falling into river\n\n"
					+ "4. Green turtles \ud83d\udc22 will submerge and cause the frog drown\n\n" 
					+ "5. Avoid the snake \ud83d\udc0d which appears on the log";break;
			case 3: instruction = "Score System & Life System\n\n"
					+ "1. Every Successful Step + 10\n"
					+ "2. Every Successful Frog to Empty Slot + 50\n"
					+ "3. Frog Hit By A Car/Truck - 50 & -1\u2665\n"
					+ "4. Frog Falls Into River - 50 & -1\u2665\n"
					+ "5. Frog Eaten By A Snake - 50 & -1\u2665\n\n"
					+ "*No point is deducted if the current point is less than 50\n"
					+ "*No point is deducted if the frog enter a non-empty slot BUT the current frog need to start from the initial position again";break;
		}
		alert.setContentText(instruction);
		alert.showAndWait();
		if(alert.getResult() == ButtonType.NEXT) {
			instructionPage++;
			if(instructionPage != 4) {
				InstructionDialog();
			}
			else{
				alert.close();
			}
		}
		else if(alert.getResult() == ButtonType.CLOSE) {
			alert.close();
		}
		if(!alert.isShowing()) {
			setPauseGame(false);
			setResumeGame(true);
			instructionPage = 1;
			setAlertClose(true);
		}
	}
	
	/**
	 * This method gets the boolean variable when the alert dialog is close.
	 * @return boolean This returns the value which represents whether the alert dialog is open or close.
	 * @since 1.9
	 */
	public boolean getAlertClose() {
		return alertClose;
	}
	
	/**
	 * This method sets the boolean variable when the alert dialog is close.
	 * @param alertClose The value whether the alert dialog is open or close.
	 * @since 1.9
	 */
	public void setAlertClose(boolean alertClose) {
		this.alertClose = alertClose;
	}
	
	/**
	 * This method gets the value to resume the game application.
	 * @return boolean This returns the value to resume the game application.
	 * @since 1.9
	 */
	public boolean getResumeGame() {
		return resumeGame;
	}

	/**
	 * This method sets the value to resume the game application.
	 * @param resumeGame The value to resume the game application.
	 * @since 1.9
	 */
	public void setResumeGame(boolean resumeGame) {
		this.resumeGame = resumeGame;
	}
	
	/**
	 * This method gets the value to pause the game application.
	 * @return boolean This returns the value to pause the game application.
	 * @since 1.9
	 */
	public boolean getPauseGame() {
		return pauseGame;
	}

	/**
	 * This method sets the value to pause the game application.
	 * @param pauseGame The value to pause the game application.
	 * @since 1.9
	 */
	public void setPauseGame(boolean pauseGame) {
		this.pauseGame = pauseGame;
	}

	/**
	 * This method gets the value to pause the game application.
	 * @return boolean This returns the value to pause the game application.
	 * @since 1.9
	 */
	public boolean getInsPauseGame() {
		return InspauseGame;
	}

	/**
	 * This method sets the value to pause the game application.
	 * @param InspauseGame The value to pause the game application.
	 * @since 1.9
	 */
	public void setInsPauseGame(boolean InspauseGame) {
		this.InspauseGame = InspauseGame;
	}
	
	/**
	 * This method gets the value for the status of sound button, whether is it clicked or not.
	 * @return boolean This returns the value of status of sound button.
	 * @since 1.9
	 */
	public boolean getSound() {
		return sound;
	}

	/**
	 * This method sets the value when the sound button is clicked.
	 * @param sound	The value when the sound button is clicked.
	 * @since 1.9
	 */
	public void setSound(boolean sound) {
		this.sound = sound;
	}

	/**
	 * This method gets the top3 player from the text file.
	 * @since 1.9
	 */
	public void getHighScore() {
		ArrayList<Integer>scoreList = new ArrayList<>();
		String top3 = "";
		FileReader filereader;
		BufferedReader bufferedreader;
		int numberOfLine = 0, j;
		int[] top = new int[3];
		try  
    	{  
    		File file = new File(".\\src\\p4_group_8_repo\\player information.txt");    //creates a new file instance 
    		
    		if(file.exists()) {
    			filereader = new FileReader(file);   //reads the file  
    			bufferedreader = new BufferedReader(filereader);  //creates a buffering character input stream  
	    		String line;
				while((line = bufferedreader.readLine())!=null)  {
	    			int index = line.indexOf(":"); //this finds the first occurrence of ":" 
	    			//in string thus giving you the index of where it is in the string
	
	    			index += 2;	//increase the index till the starting of points
	    			int score = 0;
	    			
	    			//index == -1, if ":" is not found
	    			if(index != -1)
	    				score = Integer.parseInt(line.substring(index));
	    			numberOfLine++;	//calculate the number of line of the file
	    			scoreList.add(score);	//save the score into arraylist
	    		}
				
				bufferedreader.close();
	    		filereader.close();    //closes the stream and release the resources

	    		j = 0;
				for(int i = 0;i < scoreList.size();i++) {
					for(int k = 0; k < scoreList.size();k++) {
						if(scoreList.get(k) == Collections.max(scoreList)) {
							top[j] = k;	//the highest is top1
							j++;
							scoreList.set(k,-1);
							break;
						}
					}
					if(j==3)
						break;
				}

				if(numberOfLine >= 1) {
			    	//TOP1
			    	filereader = new FileReader(file);   //reads the file  
		    		bufferedreader = new BufferedReader(filereader);
			    	for(int i = 0; i < top[0] ;i++) {
			    		bufferedreader.readLine();
			    	}
			    	top3 = top3 + "TOP1 >> " + bufferedreader.readLine() + "\n";
			    	bufferedreader.close();
			    	filereader.close();    //closes the stream and release the resources 
				}
				
		    	if(numberOfLine >= 2) {
			    	//TOP2
			    	filereader = new FileReader(file);   //reads the file  
		    		bufferedreader = new BufferedReader(filereader);
			    	for(int i = 0; i < top[1] ;i++) {
			    		bufferedreader.readLine();
			    	}
			    	top3 = top3 + "TOP2 >> " +  bufferedreader.readLine() + "\n";
			    	bufferedreader.close();
			    	filereader.close();    //closes the stream and release the resources 
		    	}
		    	
		    	if(numberOfLine >= 3) {
			    	//TOP3
			    	filereader = new FileReader(file);   //reads the file  
		    		bufferedreader = new BufferedReader(filereader);
			    	for(int i = 0; i < top[2] ;i++) {
			    		bufferedreader.readLine();
			    	}
			    	top3 = top3 + "TOP3 >> " + bufferedreader.readLine();
			    	bufferedreader.close();
			   		filereader.close();    //closes the stream and release the resources 
		    	}
    		}
			else {
					top3 = "No High Score Result Currently";
			}
    		highScoreWindow(top3);
    	}
    	catch(IOException e)  {  
    		e.printStackTrace();  
    	} 
	}
	
	/**
	 * This method displays the window which contains high score information.
	 * @param top3 The string contains the information of top3 player(s).
	 * @since 1.9
	 */
	public void highScoreWindow(String top3){
		
		new_stage = new Stage();
		
		String family = "SERIF";
		double titlesize = 25;
		double contentsize = 20;
		
		Text title = new Text("HIGH SCORE LIST");
		title.setX(50);
		title.setY(40);
		title.setFont(Font.font(family, FontWeight.BOLD, titlesize));
		title.setFill(Color.BLUE);
		
		Text content = new Text(top3);
		content.setX(20);
		content.setY(100);
		content.setFill(Color.MAGENTA);
		content.setFont(Font.font(family, FontWeight.BOLD, contentsize));
		
    	Group root = new Group();
    	Scene new_scene = new Scene(root, 350, 200, Color.BLACK);
    
    	root.getChildren().addAll(title, content);
    	
    	//not allowed to resize the screen/window
    	new_stage.setResizable(false);
    	
    	//add a custom icon
    	new_stage.getIcons().add(new Image(this.getClass().getResource("../smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
    			
    	new_stage.setScene(new_scene);
    	
    	new_stage.setTitle("HIGHSCORE");
    	
    	new_stage.show();
    }

	/**
	 * This method gets the stage created for displaying the highscore.
	 * @return Stage This returns the Stage object which is created for displaying highscore.
	 * @since 1.9
	 */
	public Stage getStage() {
		return new_stage;
	}

	/**
	 * This method closes/exits the dialog.
	 * @since 1.9
	 */
	public void close() {
		System.exit(0);
	}
	
}