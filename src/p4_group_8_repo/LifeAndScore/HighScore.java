package p4_group_8_repo.LifeAndScore;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p4_group_8_repo.actor.Actor;
import p4_group_8_repo.backgroundfunction.MyStage;

/**
* HighScore Class
* Set the highscore image as a button to get the top3 player.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class HighScore extends Actor{
	/**
	 * The highscore image as a button.
	 */
	private Image highscore;	
	private Stage new_stage = new Stage();
	
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the highscore image.
	 * This constructor sets the image of the highscore button.
	 * This constructor defines the action to take when the highscore button is clicked.
	 * @param xpos The x-coordinate of the highscore image.
	 * @param ypos The y-coordinate of the highscore image.
	 * @param width The width of the highscore image.
	 * @param height The height of the highscore image.
	 */
	public HighScore(MyStage background, int xpos, int ypos, double width, double height){
		highscore = new Image("file:src/p4_group_8_repo/highscore.png", width, height, true, true);
		setImage(highscore);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) {
				if(!new_stage.isShowing())
					getHighScore();
			   }
			}); 	
	}
	
	/**
	 * This method gets the top3 player from the text file.
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
	    			
	    			// Now index can be -1, if lets say the string had no ":" at all in it i.e. no ":" is found. 
	    			//So check and account for it.
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
	 * Display the window which contains high score information.
	 * @param top3 The string contains the information of top3 player(s).
	 */
	public void highScoreWindow(String top3){
		
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
    			
    	new_stage.setScene(new_scene);
    	
    	new_stage.setTitle("HIGHSCORE");
    	
    	new_stage.show();
    }
	
	public Stage getStage() {
		return new_stage;
	}

	public void close() {
		System.exit(0);
	}
}
