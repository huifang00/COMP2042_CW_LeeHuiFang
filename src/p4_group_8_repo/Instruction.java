package p4_group_8_repo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Instruction extends Actor{

	private Image instruction;
	private static int instructionPage = 1;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Instruction(String link, int xpos, int ypos, double width, double height){
		instruction = new Image(link, width, height, true, true);
		setImage(instruction);
		setX(xpos);
		setY(ypos);
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override 
			   public void handle(MouseEvent e) { 
			      InstructionDialog();
			   }

			private void InstructionDialog() {
				String instruction = "";
				Alert alert = new Alert(AlertType.NONE);
				alert.getButtonTypes().addAll(ButtonType.NEXT);
				alert.setTitle("INSTRUCTION");
				
				// Get the Stage.
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

				// Add a custom icon.
				stage.getIcons().add(new Image(this.getClass().getResource("smiiling-big-eyed-green-frog-clipart-6926.jpg").toString()));
				
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
							+ "3. Step on the red turtles \ud83d\udc22 to avoid the frog from falling into river\n"
							+ "4. Green turtles \ud83d\udc22 will submerge and cause the frog drown";break;
					case 3: instruction = "Score System & Life System\n\n"
							+ "1. Every Successful Step + 10\n"
							+ "2. Every Successful Frog to Empty Slot + 50\n"
							+ "3. Frog Hit The Obstacle - 50 & -1\u2665\n"
							+ "4. Frog Falls Into River - 50 & -1\u2665\n\n"
							+ "*No point is deducted if the current point is less than 50\n"
							+ "*No point is deducted if the frog enter a non-empty slot BUT the current frog need to start from the initial position again";break;
				}
				alert.setContentText(instruction);
				alert.showAndWait();
				if(alert.getResult() == ButtonType.NEXT) {
					instructionPage++;
					if(instructionPage != 4)
						InstructionDialog();
					else {
						alert.close();
						instructionPage = 1;
					}
				}
			}
		}); 
			
	}

}