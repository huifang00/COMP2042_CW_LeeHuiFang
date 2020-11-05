package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	private double width;
	private double height;
	private Image imgW1 ,imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	//int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	//boolean stop = false;	//not really used
	private boolean changeScore = false;
	private int death = 0;	//int carD = 0;
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<End>();	//dont really need can remove
	private int level = 0;
	
	public Animal() {
		
	}
	/*
	 * @param imageLink the location of the animal's image
	 */
	//public Animal(String imageLink) {
	public Animal(int xpos, double ypos, double width, double height) {
		//setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setImage(imgW1);
		//setX(300);
		//setY(679.8+movement);
		setX(xpos);
		setY(ypos);
		this.width = width;
		this.height = height;
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", width, height, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", width, height, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", width, height, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", width, height, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", width, height, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", width, height, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", width, height, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", width, height, true, true);
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
	
	//setter and getter method
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
	
	public boolean getStop() {
		return end==1;	//return true if end == 5
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
		changeScore = true;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getDeath() {
		return death;
	}
	
	public void setDeath(int death) {
		this.death = death;
	}
	
	public boolean getChangeScore() {
		return changeScore;
	}
	
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
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
			if ((now)% 11 == 0) {
				this.death++;
			}
			if (this.death == 1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", width, height, true, true));
			}
			else if (this.death == 2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", width, height, true, true));
			}
			else if (this.death == 3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", width, height, true, true));
			}
			else if (this.death == 4) {
				setY(679.8+movement);
				carDeath = false;
				this.death = 0;	//reset to 0
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
			if ((now)% 11 == 0) {
				this.death++;
			}
			if (this.death == 1) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", width, height , true, true));
			}
			else if (this.death == 2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", width, height , true, true));
			}
			else if (this.death == 3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", width, height , true, true));
			}
			else if (this.death == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", width, height , true, true));
			}
			else if (this.death == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				death = 0;
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
			if(level == 1) {
				if(getIntersectingObjects(Log.class).get(0).getLeft())	//if the object is moving left
					move(-2,0);	//display as moving together with log moving towards left
				else	//else moving right
					move (.75,0);	//display as moving together with log moving towards right
			}
			else if(level == 2) {
				if(getIntersectingObjects(Log.class).get(0).getLeft())
					move(-2,0);	//display as moving together with log moving towards left
				else
					move (1.25,0);	//display as moving together with log moving towards right
			}
			else if(level == 3) {
				if(getIntersectingObjects(Log.class).get(0).getLeft())
					move(-2,0);	//display as moving together with log moving towards left
				else
					move (.75,0);	//display as moving together with log moving towards right
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {	//intersect with turtle
			//move(-1,0);
			if(level == 1) {
				if(getIntersectingObjects(Turtle.class).get(0).getLeft())	//if the object is moving left
					move(-1,0);	//display as moving together with log moving towards left
				else	//else moving right
					move(1,0);	//display as moving together with log moving towards right
			}
			else if(level == 2) {
				if(getIntersectingObjects(Turtle.class).get(0).getLeft())
					move(-1,0);	//display as moving together with log moving towards left
				else
					move(1,0);	//display as moving together with log moving towards right
			}
			else if(level == 3) {
				if(getIntersectingObjects(Turtle.class).get(0).getLeft())
					move(-1,0);	//display as moving together with log moving towards left
				else
					move(1,0);	//display as moving together with log moving towards right
			}
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {	//intersect with wet turtle
			/*
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				this.waterDeath = true;
			} else {
				move(-1,0);
			}
			*/
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				this.waterDeath = true;
			} else {
				if(level == 1) {
					if(getIntersectingObjects(WetTurtle.class).get(0).getLeft())	//if the object is moving left
						move(-1,0);	//display as moving together with log moving towards left
					else	//else moving right
						move(1,0);	//display as moving together with log moving towards right
				}
				else if(level == 2) {
					if(getIntersectingObjects(WetTurtle.class).get(0).getLeft())
						move(-1,0);	//display as moving together with log moving towards left
					else
						move(1,0);	//display as moving together with log moving towards right
				}
				else if(level == 3) {
					if(getIntersectingObjects(WetTurtle.class).get(0).getLeft())
						move(-1,0);	//display as moving together with log moving towards left
					else
						move(1,0);	//display as moving together with log moving towards right
				}
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {	//intersect with the end slot
			inter = (ArrayList<End>) getIntersectingObjects(End.class);	//dont really need as nothing using this
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
