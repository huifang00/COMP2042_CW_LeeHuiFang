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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
	private Alert alertEnd = new Alert(AlertType.NONE);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		playerNameDialog("");
		
		background = new MyStage();
	    scene  = new Scene(background,600,800);	//remove the datatype since it is declared as global variable
	    
		froggerback = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW_cropped.png");
		background.add(froggerback);
		
		start = new Start(250, 350, 100, 100);
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
            		printAlertEnd();
            		background.stopMusic();
            		stop();	//timer stop
            		background.stop();	//timer stop
            	}
            	
            }
        };
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
    		  digit = new Digit(background, k, 360 - shift, 25, 30, 30);
    		  ArrayDigit.add(digit);
    		  background.add(digit);
    		  //addDigit(background, k, 360 - shift, 25);	//call the method to add the digit
    		  shift+=30;
    	}
    }
    
    public void addDigit(MyStage background, int n, int x, int y) {
    	Digit digit;
    	digit = new Digit(background, n, x, y, 30, 30);
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
    
    public void setPlayerName(String playerName) {
    	this.playerName = playerName;
    }
    
    public String getPlayerName() {
    	return playerName;
    }

	protected void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}

	protected boolean getNextLevel() {
		return nextLevel;
	}
	
    public void playerNameDialog(String Message) {
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
    		if(!result.get().isBlank()) {
    			if(!isNameUsed(result.get()) && !containSymbol(result.get())) {
	    			setPlayerName(result.get());
	    			System.out.println("Your name: " + getPlayerName()); 
    			}
    			else if(isNameUsed(result.get())){
    				playerNameDialog("\n**Name Used By Other Player**");
    			}
    			else if(containSymbol(result.get())){
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
    
    public void printAlertEnd() {
    	String levelmsg;	//variable to save the message of score for each level
    	score = level1.getScore() + level2.getScore() + level3.getScore();
    	this.alertEnd = new Alert(AlertType.INFORMATION);
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
		alertEnd.show();
		save();	//call the method to save score and player name in file
    }
    
    public void printAlertNextLevel(int score) {
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
			alert.setContentText("Level 1: " + score +"!\n"+"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		else if(level == 2) {
			levelmsg = "Level 1: " + level1.getScore() + "!\nLevel 2: " + level2.getScore() + "!\n";
			alert.setContentText(levelmsg +"Highest Possible Score: " + highscore);	//"Highest Possible Score: 800"
		}
		alert.show();
    }

    public boolean isNameUsed(String enteredName) {
    	String line, name = "";  
    	try  
    	{  
    		File file = new File(".\\src\\p4_group_8_repo\\player information.txt");    //creates a new file instance 
    		if(file.exists()) {
    			FileReader filereader = new FileReader(file);   //reads the file  
    			BufferedReader bufferedreader = new BufferedReader(filereader);  //creates a buffering character input stream  
    		while((line = bufferedreader.readLine())!=null)  {
    			//String filename = "abc.def.ghi";     // full file name
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
}
