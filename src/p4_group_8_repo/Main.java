package p4_group_8_repo;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.TilePane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal = new Animal();
	private Scene scene;	
	private BackgroundImage froggerback;
	private Start start;
	private int level = 1;//
	private Level1 level1 = new Level1();//
	Alert alert = new Alert(AlertType.NONE);//
	private Level2 level2 = new Level2();//
	private boolean printGame;//
	private Level3 level3 = new Level3();//
	private int highscore;//
	private boolean nextLevel;//
	private String username;//
	private boolean enterUsername = true;//
	private int score;//
	private Digit digit;//
	ArrayList<Digit> ArrayDigit = new ArrayList<Digit>();	//save the actor of Digit
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Username();
		
		background = new MyStage();
	    scene  = new Scene(background,600,800);	//remove the datatype since it is declared as global variable
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

		froggerback = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png");
		background.add(froggerback);
		
		start = new Start(250,350);
		background.add(start);	//add start/play button
		
		background.start();
		primaryStage.setScene(scene);

		// Set the title for the application
		primaryStage.setTitle("Frogger");
		
		// Add a custom icon.
		primaryStage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));

		primaryStage.show();
		start();  
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(start.getGameStart() == true) {	//Level1
            		background.remove(start);	//once the button is clicked then remove the button
            		start.setGameStart(false);
            		addDigit(background, 0, 360, 25);
            		level1 = new Level1(background);
            		setAnimal(level1.animal);
            		setPrintGame(false);	// to prevent the next second on printing this condition
            		animal.setLevel(level);	//set the level in animal class for the speed
            		start();
            	}
            	else if(level == 2 && getPrintGame()) {	//Level2
            		animal.setPoints(0);	//display the score (digit image) as 0
            		animal.setLevel(level);	//set the level in animal class for the speed
            		level1.remove(background);
            		level2 = new Level2(background, animal);
            		setPrintGame(false);
            	}
            	else if(level == 3 && getPrintGame()) {	//Level3
            		animal.setPoints(0);	//display the score (digit image) as 0
            		animal.setLevel(level);	//set the level in animal class for the speed
            		level2.remove(background);
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
            			level3.remove(background);
            			level = 0;	//end the game
            		}
            		else {
            			highscore = level * 800;
            			printAlertNextLevel(animal.getPoints());
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
            		background.stopMusic();
            		stop();
            		background.stop();
            		printAlertEnd();
            	}
            	
            }
        };
    }
	protected void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
		
	}

	protected boolean getNextLevel() {
		return nextLevel;
	}

	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	//clear previous digit(s)
    	if(n == 0 || n < 100) {	//new condition to remove the previous number(digit) at (300,25)
    		removeDigit(background);
    	}
    	/*
    	if(n < 100) {	//new condition to remove the previous number(digit) at (300,25)
    		removeDigit(background);
    	}
    	*/
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  digit = new Digit(background, k, 360 - shift, 25);
    		  ArrayDigit.add(digit);
    		  background.add(digit);
    		  //addDigit(background, k, 360 - shift, 25);	//call the method to add the digit
    		  shift+=30;
    	}
    }
    
    public void addDigit(MyStage background, int n, int x, int y) {
    	Digit digit;
    	digit = new Digit(background, n, x, y);
    	background.add(digit);
    }
    
    public void removeDigit(MyStage background) {	//remove all digits from background
    	for(Digit digit: ArrayDigit) {
    		background.remove(digit);
    	}
    	ArrayDigit.clear();
    }
    
    public void setAnimal(Animal animal) {
    	this.animal = animal;
    }
    
    public Animal getAnimal() {
    	return animal;
    }
    public void setPrintGame(boolean printGame) {
    	this.printGame = printGame;
    }
    
    public boolean getPrintGame() {
    	return printGame;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setEnter(boolean enterUsername) {
    	this.enterUsername = enterUsername;
    }
    
    public boolean getEnter() {
    	return enterUsername;
    }

    public void Username() {
		if(getEnter()) {
    		TextInputDialog dialog = new TextInputDialog("name");
    		dialog.setTitle("Enter Name");
    		dialog.setHeaderText("Welcome To Frogger!!!");
    		dialog.setContentText("Please enter your name:");
    		
    		// Get the Stage.
    		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

    		// Add a custom icon.
    		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
    		
    		// Traditional way to get the response value.
    		Optional<String> result = dialog.showAndWait();
    		if (result.isPresent()){
    			setUsername(result.get());
    		    System.out.println("Your name: " + getUsername()); 
    		    setEnter(false);
    		}
    	}
	}
    
    public void printAlertEnd() {
    	score = level1.getScore() + level2.getScore() + level3.getScore();
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("You Have Won The Game!");
		//alert.setHeaderText("Your High Score: "+ animal.getPoints()+"!");
		alert.setHeaderText("Your High Score: "+ score +"!");
		alert.setContentText("Highest Possible Score: " + highscore);
		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		alert.show();
    }
    
    public void printAlertNextLevel(int score) {
    	alert = new Alert(AlertType.NONE);
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
		alert.setTitle("NEXT LEVEL");
		alert.setHeaderText("PROCEED TO NEXT LEVEL?");
		//alert.setContentText("Level " + level + " Score :"+ animal.getPoints()+"!\n"+"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		alert.setContentText("Level " + level + " Score :"+ score +"!\n"+"Highest Possible Score: 800");	//"Highest Possible Score: 800"
		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
		alert.show();
    }

}
