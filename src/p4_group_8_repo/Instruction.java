package p4_group_8_repo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Instruction extends Actor{

	private double width;
	private double height;
	private Image instruction;
	//private boolean printInstruction = false;
	//private Alert alert;
	private static int instructionPage = 1;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	public Instruction() {
		//default constructor
	}
	
	public Instruction(int xpos, int ypos, double width, double height){
		instruction = new Image("file:src/p4_group_8_repo/instruction.png", width, height, true, true);
		setImage(instruction);
		setX(xpos);
		setY(ypos);
		this.width = width;
		this.height = height;
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
					case 1: instruction = "1. Use the key W to move up\n"
							+ "2. Use the key S to move down\n"
							+ "3. Use the key A to move left\n"
							+ "4. Use the key D to move right";break;
					case 2: instruction = "Help the frog to the empty slot";break;
					case 3: instruction = "1. Avoid the moving car(s) and truck(s)\n\n"
							+ "2. Logs of different lengths is to help the frog to cross the river\n"
							+ "   Jump on the log to avoid the frog from falling into river\n\n"
							+ "3. Step on the red turtles to avoid the frog from falling into river\n"
							+ "	  However, green turtles will submerge and cause the frog drown and lose a life\n";break;
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
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	/*
	public boolean getPrintInstruction() {
		return printInstruction;
	}

	public void setPrintInstruction(boolean printInstruction) {
		this.printInstruction = printInstruction;
	}
	
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	*/
}