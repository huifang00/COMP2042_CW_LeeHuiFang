package p4_group_8_repo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
* FROGGER
* The Frogger application is a game that helps the frog to cross the traffic and river.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal = new Animal();
	private Scene scene;	
	private BackgroundImage froggerback;
	private Play play;
	private int level = 1;	//initialized the level to 1
	private Level1 level1 = new Level1();//
	private Alert alert = new Alert(AlertType.NONE);//
	private Level2 level2 = new Level2();//
	private boolean printGame;//
	private Level3 level3 = new Level3();//
	private int highscore;//
	private boolean nextLevel;//
	private String playerName;//
	private int score;//
	private Digit digit;//
	private ArrayList<Digit> ArrayDigit = new ArrayList<Digit>();	//save the actor of Digit
	//private Instruction instruction = new Instruction();//Instruction image
	private ArrayList<Life> ArrayLife = new ArrayList<Life>();	//save the actor of Life
	private Life lifeImg;
	private Instruction howtoplay;
	private Instruction instruction = new Instruction("file:src/p4_group_8_repo/instruction.png", 560, 10, 30, 30);
	private Pause pause = new Pause(525, 10, 30, 30);
	private Resume resume = new Resume(525, 10, 30, 30);
	private Sound sound;
	private HighScore highscoreButton;
	
	/**
	* This is the main method which run the whole application.
	* @param args Unused.
	*/
	public static void main(String[] args) {
		launch(args);
	}

	/**
	* This is the main method which display a pop up dialog for player name and display the scene with background.
	* @param primaryStage The JavaFX Stage class is the top level JavaFX container.
	* @see Exception
	*/
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		playerNameDialog("");
		
		background = new MyStage();
	    scene  = new Scene(background, 600, 800);	//remove the datatype since Scene is declared as global variable
	    
		froggerback = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png", 600, 800);
		background.add(froggerback);

		//create the menu before the game start
		
		play = new Play(230, 250, 120, 120);
		background.add(play);	//add start/play button
		
		howtoplay = new Instruction("file:src/p4_group_8_repo/howtoplay.png", 150, 350, 300, 300);
		background.add(howtoplay);	//addprintinstruction at main page
		
		highscoreButton = new HighScore(background, 155, 450, 300, 300);
		background.add(highscoreButton);
		
		//create sound button to play music or mute
		sound = new Sound(background, 490, 10, 30, 30);
		background.add(sound);
		
		background.start();
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		//set Stage boundaries to visible bounds of the main screen
		double screen_x = ((bounds.getMinX() + bounds.getMaxX())/2) - 300;
		double screen_y= bounds.getMinY();
		primaryStage.setX(screen_x);
		primaryStage.setY(screen_y);
		
		//not allowed to resize the screen/window
		primaryStage.setResizable(false);
		
		primaryStage.setScene(scene);

		// Set the title for the application
		primaryStage.setTitle("Frogger");
		
		// Add a custom icon.
		primaryStage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));

		primaryStage.show();
		start();
	}
	
	/**
	* This is the method to create animation and handle() method is called in every frame of the animation.
	* In handle method, different condition are given to perform specific action.
	*/
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(play.getGamePlay() == true) {	//Level1
            		background.remove(play);	//once the button is clicked then remove the button
            		play.setGamePlay(false);
            		background.remove(howtoplay);	//remove the button
            		background.remove(highscoreButton);
            		background.add(instruction);
            		background.add(pause);
            		background.add(new Digit(0, 450, 10, 30, 30));
            		level1 = new Level1(background);
            		setAnimal(level1.animal);
            		setPrintGame(false);	// to prevent the next second on printing this condition
            		animal.setLevel(level);	//set the level in animal class for the speed
            		setLife(3);
            		start();
            	}
            	else if(level == 2 && getPrintGame()) {	//Level2
            		animal.setPoints(0);	//display the score (digit image) as 0
            		animal.setLevel(level);	//set the level in animal class for the speed
            		//setLife(3);
            		//animal.setLife(3);
            		//level1.remove(background);
            		level1.remove();
            		level2 = new Level2(background, animal);
            		setPrintGame(false);
            	}
            	else if(level == 3 && getPrintGame()) {	//Level3
            		animal.setPoints(0);	//display the score (digit image) as 0
            		animal.setLevel(level);	//set the level in animal class for the speed
            		//setLife(3);
            		//animal.setLife(3);
            		level2.remove();
            		level3 = new Level3(background, animal);
            		setPrintGame(false);
            	}
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		if(level == 1) {	//save the score in level1 class
            			level1.setScore(animal.getPoints());
            		}
            		else if(level == 2) {	//save the score in level2 class
            			level2.setScore(animal.getPoints());
            		}
            		if(level == 3) {
            			highscore = level * 800;
            			level3.setScore(animal.getPoints());	//save the score in level3 class
            			level3.remove();
            			level = 0;	//end the game
            		}
            		else {
            			highscore = level * 800;
            			printNextLevel();
	            		animal.setEnd(0);	//set the end back to 0 to prevent getStop() infinite loop
	            		setNextLevel(true);	//in order to run the condition for increasing to nextlevel
            		}
            	}
            	if (alert.getResult() == ButtonType.YES && getNextLevel()) {
        			level++;
        			setPrintGame(true);
        			setNextLevel(false);	//to prevent the next second on running this condition till the next alert box appear
        		}
            	else if (alert.getResult() == ButtonType.NO || level == 0){	
            		printEnd();
            		
            		if(!sound.getMuted()) 
            			background.stopMusic();
            		
            		stop();	//timer stop
            		background.stop();	//timer stop
            	}
            	if(animal.changeLife()) {
            		setLife(animal.getLife());
            	}
            	if(animal.noLife()) {
            		printGameOver(animal.getPoints());
            		if(!sound.getMuted())
            			background.stopMusic();
            		stop();
            		background.stop();
            	}
            	/*
            	if(instruction.getPauseGame()) {
            		pause();
            	}
            	if(instruction.getResumeGame()) {
            		resume();
            	}
            	*/
            	if(instruction.getPauseGame() || pause.getPauseGame()) {
            		pause();
                	background.remove(pause);
                	background.add(resume);
            	}
            	if(instruction.getResumeGame()|| resume.getResumeGame()) {
            		resume();
                	background.remove(resume);
                	background.add(pause);
            	}
            }
        };
	}

	/**
	* This is the method to play the background music, create and start the animation timer.
	*/
	public void start() {
		if(!sound.getMuted())
			background.playMusic();
    	createTimer();
        timer.start();
    }

	/**
	* This is the method to stop the animation timer.
	*/
    public void stop() {
        timer.stop();
    }
    
    /**
	* This is the method to display the images of digit as score on the interface.
	* @param n The value to be showed on the interface such as current score.
	*/
    public void setNumber(int n) {
    	int shift = 0;
    	//clear previous digit(s) to save memory space
    	if(n == 0 || n < 100) {
    		for(Digit digit: ArrayDigit) {
        		background.remove(digit);
        	}
        	ArrayDigit.clear();
    	}
    	
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  digit = new Digit(k, 450 - shift, 10, 30, 30);
    		  ArrayDigit.add(digit);
    		  background.add(digit);
    		  shift+=30;		
    	}
    }
   
    /**
	* This is the method to display the image of life on the interface.
	* @param life The number of life left.
	*/
    public void setLife(int life) {
		int shift = 0;
		if(life == 3) {
			//ArrayLife.clear(); //clear previous level life
			for(int i = 0; i < 3;i++) {
				lifeImg = new Life(384 + shift, 50, 25, 25);
	    		ArrayLife.add(lifeImg);
	    		background.add(lifeImg);
				shift += 33;
			}
		}
		else if(life == 2 || life == 1 || life == 0){
			background.remove(ArrayLife.get(0));
			ArrayLife.remove(0);
		}
	}
    
    /**
	* This is the method to set the object created from Animal class to the global variable.
	* @param animal The object created of Animal class.
	*/
    public void setAnimal(Animal animal) {
    	this.animal = animal;
    }
    
    /**
	* This is the method to get the object created from Animal class from global variable.
	* @return Animal This returns the object of Animal class.
	*/
    public Animal getAnimal() {
    	return animal;
    }
    
    /**
	* This is the method to set the boolean variable to display the game screen.
	* @param printGame Value to display the game screen.
	*/
    public void setPrintGame(boolean printGame) {
    	this.printGame = printGame;
    }
    
    /**
	* This is the method to get signal to display the game screen.
	* @return boolean This returns signal to display the game screen..
	*/
    public boolean getPrintGame() {
    	return printGame;
    }
    
    /**
	* This is the method to set the player name to the global variable.
	* @param playerName The name of player given.
	*/
    public void setPlayerName(String playerName) {
    	this.playerName = playerName;
    }
    
    /**
	* This is the method to get the player name who is playing currently.
	* @return String This returns the name of current player.
	*/
    public String getPlayerName() {
    	return playerName;
    }

    /**
	* This is the method to set the boolean variable to proceed to next level.
	* @param nextLevel The signal whether to proceed to next level.
	*/
	protected void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}

	/**
	* This is the method to get the signal on whether to proceed the next level.
	* @return boolean This returns the signal to proceed to the next level.
	*/
	protected boolean getNextLevel() {
		return nextLevel;
	}
	
	/**
	* This is the method to display the pop up dialog which ask for player's name.
	* @param Message The error message if the name cannot be used.
	*/
    public void playerNameDialog(String Message) {
    	//String message = "";
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Enter Name");
    	dialog.setHeaderText("Welcome To Frogger!!!" + Message);
    	dialog.setContentText("Please enter your name:");
    		
    	// Get the Stage.
    	Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

    	// Add a custom icon.
    	stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
    		
    	// To get the response value.
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){	//ok was pressed
    		String input = result.get(); //assigned to a variable easier to use
    		if(!input.isBlank()) {
    			if(!isNameUsed(input) && !containSymbol(input) && input.length() <= 18) {
	    			setPlayerName(input);
	    			System.out.println("Your name: " + getPlayerName()); 
    			}
    			else if(input.length() > 18) {
    				playerNameDialog("\n**Name Cannot Exceed 18 Characters**");
    			}
    			else if(isNameUsed(input)){
    				playerNameDialog("\n**Name Used By Other Player**");
    			}
    			else if(containSymbol(input)){
    				playerNameDialog("\n**Name Cannot Contain Special Characters**");
    			}
    		}
    		else {
    			playerNameDialog("\n**Name Cannot Be Empty**");
    		}
    	}
    	else {	//cancel is pressed
    		System.exit(0);	//exit the application
    	}
	}
    
    /**
	* This is the method to display the pop up dialog which display at the end of the game.
	*/
    public void printEnd() {
    	String levelmsg;	//variable to save the message of score for each level
    	this.score = level1.getScore() + level2.getScore() + level3.getScore();
    	Alert alertEnd = new Alert(AlertType.INFORMATION);
		alertEnd.setTitle("You Have Won The Game!");
		alertEnd.setHeaderText("Your Total Score: "+ score +"!");
		// Get the Stage.
		Stage stage = (Stage) alertEnd.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		if(level == 1)
			alertEnd.setContentText("Level 1: " + score +"!\n"+"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		else if(level == 2) {
			levelmsg = "Level 1: " + level1.getScore() + "!\nLevel 2: " + level2.getScore() + "!\n";
			alertEnd.setContentText(levelmsg +"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		}
		else if(level == 3) {
			levelmsg = "Level 1: " + level1.getScore() + "!\nLevel 2: " + level2.getScore() + "!\nLevel 3: " + level3.getScore() + "!\n";
			alertEnd.setContentText(levelmsg +"Highest Possible Score: " + highscore);
		}

		//alert.setOnHidden(evt -> Platform.exit());
		alertEnd.setOnCloseRequest(evt -> System.exit(0));	//use a handler for the onCloseRequest event for the alert to close the application when the alert is closed:
		alertEnd.show();
		save();	//call the method to save score and player name in file
    }
    
    /**
	* This is the method to display the pop up dialog which display at the end of each level.
	*/
    public void printNextLevel() {
    	String levelmsg;	//variable to save the message of score for each level
    	this.alert = new Alert(AlertType.NONE);
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
		alert.setTitle("NEXT LEVEL");
		alert.setHeaderText("PROCEED TO NEXT LEVEL?");
		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		
		if(level == 1)
			alert.setContentText("Level 1: " + level1.getScore() +"!\n"+"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		else if(level == 2) {
			levelmsg = "Level 1: " + level1.getScore() + "!\nLevel 2: " + level2.getScore() + "!\n";
			alert.setContentText(levelmsg +"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		}
		alert.show();
    }
 
    /**
	* This is the method to display the game over dialog.
	* @param score This value is the last obtained score from the game.
	*/
    public void printGameOver(int score) {
    	if(level == 1) {
    		this.score = score;
    	}
    	else if(level == 2) {
    		this.score = level1.getScore() + score;
    	}
    	else if(level == 3) {
    		this.score = level1.getScore() + level2.getScore() + score;
    	}
    	Alert alertGameOver  = new Alert(AlertType.INFORMATION);
		alertGameOver.setTitle("GAME OVER!!!");
		alertGameOver.setHeaderText("GAME OVER!!!\nYou Have No Life Left");
		alertGameOver.setContentText("Your Total Score: "+ this.score +"!");
		// Get the Stage.
		Stage stage = (Stage) alertGameOver.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		
		//alert.setOnHidden(evt -> Platform.exit());
		alertGameOver.setOnCloseRequest(evt -> System.exit(0));
		
		alertGameOver.show();
		save();	//call the method to save score and player name in file
    }
    
    /**
	* This is the method check is the name given player used by others.
	* @param enteredName The name entered by the player.
	* @return boolean This returns the value on whether the name is used.
	*/
    public boolean isNameUsed(String enteredName) {
    	String line, name = "";  
    	try  
    	{  
    		File file = new File(".\\src\\p4_group_8_repo\\player information.txt");    //creates a new file instance 
    		if(file.exists()) {
    			FileReader filereader = new FileReader(file);   //reads the file  
    			BufferedReader bufferedreader = new BufferedReader(filereader);  //creates a buffering character input stream  
    		while((line = bufferedreader.readLine())!=null)  {
    			int index = line.indexOf(":"); //this finds the first occurrence of ":" 
    			//in string thus giving you the index of where it is in the string

    			// Now index can be -1, if lets say the string had no ":" at all in it i.e. no ":" is found. 
    			//So check and account for it.
    			if (index != -1) 
    			{
    			    name = line.substring(0 , index); //this will give name before ":"
    			}
    			if(name.equals(enteredName)) {
    				bufferedreader.close();
    	    		filereader.close();    //closes the stream and release the resources 
    				return true;
    			}
    		}  
    		bufferedreader.close();
    		filereader.close();    //closes the stream and release the resources 
    		return false;
    		}
    	}  
    	catch(IOException e)  {  
    		e.printStackTrace();  
    	}
		return false;  
    }
    
    /**
   	* This is the method check is the name given player contains any special character(s).
   	* @param enteredName The name entered by the player.
   	* @return boolean This returns the value on whether the name contains any special character(s).
   	*/
    public boolean containSymbol(String enteredName) {
    	String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for (int i=0; i < enteredName.length() ; i++)
        {
            char ch = enteredName.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                return true;
            }    
        }
        return false;
    }
    
    /**
   	* This is the method save a record of player name and score achieved.
   	*/
    public void save() {
    	try {
    		//directory of the file
    		File file = new File(".\\src\\p4_group_8_repo\\player information.txt");	
    		if(!file.exists()) {	//if the file is not created
    			file.createNewFile();
    		}

    		//String to be displayed in the file
    		String content = playerName + ": " + score +"\n";
    		
    		//true is to append the content to file
        	FileWriter filewriter = new FileWriter(file,true);
        	
        	//Write the content
        	filewriter.write(content);
        	
        	//Flush the stream
        	filewriter.flush();
        	
        	//Closing BufferedWriter Stream
        	filewriter.close();	//BufferedWriter close the underlying writer
       	}
    	catch(IOException e) {
    		System.out.println("An error occured");
    	}
    }
    
    /**
   	* This is the method pause the game.
   	*/
    public void pause() {
    	background.stopMusic();
    	background.remove(sound);	//remove the sound button
    	background.stop();
    	animal.setNoMove(true);
    	pause.setPauseGame(false);
    	instruction.setPauseGame(false);
    }
    
    /**
   	* This is the method resume the game after pausing the game.
   	*/
    public void resume() {
    	if(!sound.getMuted())
    		background.playMusic();	//if the sound is not muted
    	background.add(sound);	//add back the sound button
    	background.start();
    	animal.setNoMove(false);
    	resume.setResumeGame(false);
    	instruction.setResumeGame(false);
    }
    
}
