package p4_group_8_repo.actor.mainfunction;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import p4_group_8_repo.actor.Actor;

/**
* Instruction Class
* Set the instruction image as a button.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Instruction extends Actor{
	/**
	 * The instruction image as a button.
	 */
	private Image instruction;
	/**
	 * The current page of the instruction.
	 */
	private static int instructionPage = 1;
	/**
	 * The value to resume the game application.
	 */
	private boolean resumeGame = false;
	/**
	 * The value to pause the game application.
	 */
	private boolean pauseGame = false;
	/**
	* This is the abstract method from superclass.
	* @param now The timestamp of the current frame given in nanoseconds.
	*/
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Class constructor specifies and sets the position and size of the instruction image.
	 * This constructor sets the image of the instruction button.
	 * This constructor defines the action to take when the instruction button is clicked.
	 * @param link The file location of the instruction image.
	 * @param xpos The x-coordinate of the instruction image.
	 * @param ypos The y-coordinate of the instruction image.
	 * @param width The width of the instruction image.
	 * @param height The height of the instruction image.
	 */
	public Instruction(String link, int xpos, int ypos, double width, double height){
		instruction = new Image(link, width, height, true, true);
		setImage(instruction);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
					setPauseGame(true);
					InstructionDialog();
			   }

			private void InstructionDialog() {
				String instruction = "";
				Alert alert = new Alert(AlertType.NONE);
				alert.getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
				alert.setTitle("INSTRUCTION");
				//setPauseGame(true);
	
				// Get the Stage.
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

				// Add a custom icon.
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
				}
			}
		}); 
			
	}

	/**
	 * This method is get the value to resume the game application.
	 * @return boolean This returns the value to resume the game application.
	 */
	public boolean getResumeGame() {
		return resumeGame;
	}

	/**
	 * This method is set the value to resume the game application.
	 * @param resumeGame The value to resume the game application.
	 */
	public void setResumeGame(boolean resumeGame) {
		this.resumeGame = resumeGame;
	}

	/**
	 * This method is get the value to pause the game application.
	 * @return boolean This returns the value to pause the game application.
	 */
	public boolean getPauseGame() {
		return pauseGame;
	}

	/**
	 * This method is set the value to pause the game application.
	 * @param pauseGame The value to pause the game application.
	 */
	public void setPauseGame(boolean pauseGame) {
		this.pauseGame = pauseGame;
	}
}