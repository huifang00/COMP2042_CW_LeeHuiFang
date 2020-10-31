package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	/*
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	*/
	private int width = 40;
	private int height = 40;
	private Image imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", width, height, true, true),
	imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", width, height, true, true),
	imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", width, height, true, true),
	imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", width, height, true, true),
	imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", width, height, true, true),
	imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", width, height, true, true),
	imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", width, height, true, true),
	imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", width, height, true, true);
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	//int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	//boolean stop = false;	//not really used
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Animal() {
		
	}
	/*
	 * @param imageLink the location of the animal's image
	 */
	//public Animal(String imageLink) {
	public Animal(int xpos, double ypos) {
		//setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setImage(imgW1);
		//setX(300);
		//setY(679.8+movement);
		setX(xpos);
		setY(ypos);
		/*
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true);
		*/
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		//int bounds = 0;	//can remove since bounds is not used
		
		// condition for the animal not to exceed the bound
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
	
		if (getX()<0) {
			move(movement*2, 0);
		}	//move the if x coordinate more than 600 togehter with less than 0
		else if (getX()>600) {
			move(-movement*2, 0);
		}
		
		carDeath = setCarDeath(now,carDeath);
		waterDeath = setWaterDeath(now,waterDeath);
		Intersection();	//intersection method
		
		/*	this code is not used 
		if(getX() == 240 && getY() == 82) {
			stop = true;
		}
		*/
	}
	public boolean getStop() {
		return end==5;	//return true if end == 5
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	//newly created setCarDeath method to change the animal photo
	public boolean setCarDeath(long now,boolean carDeath) {
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				this.carD++;
			}
			if (this.carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", width, height, true, true));
			}
			if (this.carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", width, height, true, true));
			}
			if (this.carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", width, height, true, true));
			}
			if (this.carD == 4) {
				setY(679.8+movement);
				carDeath = false;
				this.carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", width, height, true, true));
				noMove = false;
				if (this.points>50) {
					this.points-=50;
					this.changeScore = true;
				}
			}
			
		}
		return carDeath;
	}
	
	//newly created setWaterDeath method to change the animal photo
	public boolean setWaterDeath(long now,boolean waterDeath) {
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				this.carD++;
			}
			if (this.carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", width, height , true, true));
			}
			if (this.carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", width, height , true, true));
			}
			if (this.carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", width, height , true, true));
			}
			if (this.carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", width, height , true, true));
			}
			if (this.carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", width, height, true, true));
				noMove = false;
				if (this.points>50) {
					this.points-=50;
					this.changeScore = true;
				}
			}
			
		}
		return waterDeath;
	}
	
	//newly created Intersection Method
	public void Intersection() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {	//intersect with truck
			this.carDeath = true;
		}
		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {	//intersect with log
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);	//display as moving together with log moving towards left
			else
				move (.75,0);	//display as moving together with log moving towards right
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {	//intersect with turtle
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {	//intersect with wet turtle
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				this.waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {	//intersect with the end slot
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {	//if the slot is unavailable
				this.end--;
				//this.points-=10;	// add code //should not add the 10 points of moving up once if the slot is unavailable
				this.points-=50;	// for entering the wrong slot -50points
			}//else	//not sure is the point is for crashing or not
			this.points+=50;
			this.changeScore = true;
			this.w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			this.end++;
			System.out.println(end);
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){	//frog drop into water
			this.waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
}
