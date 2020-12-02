package p4_group_8_repo.actor;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import p4_group_8_repo.actor.obstacle.CarObstacle;
import p4_group_8_repo.actor.obstacle.Log;
import p4_group_8_repo.actor.obstacle.Snake;
import p4_group_8_repo.actor.obstacle.TruckObstacle;
import p4_group_8_repo.actor.obstacle.Turtle;
import p4_group_8_repo.actor.obstacle.WetTurtle;

/**
* Animal Class
* Create animal as frog as main character in the application.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public class Animal extends Actor {
	private double width;
	private double height;
	private Image imgW1 ,imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movementY = 13.3333333*2;
	private double movementX = 10.666666*2;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int death = 0;
	private double w = 800;
	private int level = 0;
	private int life = 3;
	private boolean changeLife = false;
	
	/**
	* Default constructor
	*/
	public Animal() {
		//default constructor
	}
	
	/**
	 * Class constructor specifies the position and size of frog image.
	 * This constructor defines the action of frog when a specific key is pressed or released.
	 * @param xpos The x-coordinate of the frog.
	 * @param ypos The y-coordinate of the frog.
	 * @param width The width of the frog.
	 * @param height The height of the frog.
	 * @since 1.0
	 */
	public Animal(int xpos, double ypos, double width, double height) {
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", width, height, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", width, height, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", width, height, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", width, height, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", width, height, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", width, height, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", width, height, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", width, height, true, true);
		setImage(imgW1);
		setX(xpos);
		setY(ypos);
		this.width = width;
		this.height = height;
		//when keyboard key is pressed
		setOnKeyPressed(event -> {
			if (noMove) {
				
			}
			else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movementY);
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
		            	 move(0, movementY);
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
	                move(0, -movementY);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movementY);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
		});
		//when the pressed key is released
		setOnKeyReleased(event -> {
			if (noMove) {
				
			}
			else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movementY);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movementY);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
		});
	}
	
	/**
	* This is the method which allows the frog to perform some action(s).
	* @param now The time stamp of the current frame given in nanoseconds.
	* @since 1.0
	*/
	@Override
	public void act(long now) {
		
		// condition for the animal not to exceed the bound
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movementY);
		}
	
		if (getX()<0) {
			move(movementY*2, 0);
		}	
		//move the if x coordinate more than 600 together with less than 0
		else if (getX()>600) {
			move(-movementY*2, 0);
		}
		
		carDeath = setCarDeath(now,carDeath);
		waterDeath = setWaterDeath(now,waterDeath);
		Intersection();	//intersection method
		
	}
	
	/**
	* This is the method to get the value whether the slot is fully occupied.
	* @return boolean This returns the value whether the slot is fully occupied.
	* @since 1.0
	*/
	public boolean getStop() {
		return end==5;	//return true if end == 5
	}
	
	/**
	* This is the method to set the end value of the application.
	* @param end The value whether to end the application.
	* @since 1.0.1
	*/
	public void setEnd(int end) {
		this.end = end;
	}
	
	/**
	* This is the method to get the points player get.
	* @return int This returns the points player get.
	* @since 1.0
	*/
	public int getPoints() {
		return points;
	}
	
	/**
	* This is the method to set the points player get.
	* @param points The points that the player get.
	* @since 1.0.1
	*/
	public void setPoints(int points) {
		this.points = points;
		changeScore = true;
	}
	
	/**
	* This method sets the current level.
	* @param level The level the player has reached.
	* @since 1.0.2
	*/
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	* This is the method to update the current score.
	* @return boolean This returns the value on whether to update the current score.
	* @since 1.0
	*/
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	* This is the method to get the life of the frog.
	* @return This returns the life of the frog has.
	* @since 1.0.3
	*/
	public int getLife() {
		return life;
	}

	/**
	 * This is the method to set the life for each level.
	 * @param life The number of life for each level.
	 * @since 1.0.3
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	* This is the method to get the value whether to end the game depends on the life the frog has.
	* @return boolean This returns the value whether the to end the game due to no life left.
	* @since 1.0.3
	*/
	public boolean noLife() {
		return life == 0;
	}
	
	/**
	* This is the method to update the current life
	* @return boolean This returns the value on whether to update the current life.
	* @since 1.0.3
	*/
	public boolean changeLife() {
		if(changeLife) {
			changeLife = false;
			return true;
		}
		return false;
	}
	
	/**
	* This is the method to set the value of carDeath and set the image of frog when hit by a car.
	* @since 1.0.1
	* @param now The time stamp of the current frame given in nanoseconds.
	* @param carDeath The value of whether the frog is hit by car.
	* @return boolean This returns the value of carDeath of frog. 
	*/
	public boolean setCarDeath(long now,boolean carDeath) {
		Image death1 = new Image("file:src/p4_group_8_repo/cardeath1.png", width, height, true, true);
		Image death2 = new Image("file:src/p4_group_8_repo/cardeath2.png", width, height, true, true);
		Image death3 = new Image("file:src/p4_group_8_repo/cardeath3.png", width, height, true, true);
		Image death4 = new Image("file:src/p4_group_8_repo/cardeath4.png", width, height, true, true);

		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				this.death++;
			}
			if (this.death  == 1) {
				setImage(death1);
			}
			else if (this.death == 2) {
				setImage(death2);
			}
			else if (this.death == 3) {
				setImage(death3);
			}
			else if (this.death == 4) {
				setX(300);
				setY(679.8+movementY);
				carDeath = false;
				this.life--;	//decrease one life
				this.changeLife = true;
				this.death = 0;	//reset to 0
				setImage(death4);
				noMove = false;
				if (this.points>50) {
					this.points-=50;
					this.changeScore = true;
				}
			}
		}
		return carDeath;
	}
	
	/**
	* This is the method to set the value of waterDeath and set the image of frog if frog drowns.
	* @since 1.0.1
	* @param now The time stamp of the current frame given in nanoseconds.
	* @param waterDeath The value of whether the frog drowns.
	* @return boolean This returns the value of waterDeath of frog. 
	*/
	public boolean setWaterDeath(long now,boolean waterDeath) {
		Image death1 = new Image("file:src/p4_group_8_repo/waterdeath1.png", width, height, true, true);
		Image death2 = new Image("file:src/p4_group_8_repo/waterdeath2.png", width, height, true, true);
		Image death3 = new Image("file:src/p4_group_8_repo/waterdeath3.png", width, height, true, true);
		Image death4 = new Image("file:src/p4_group_8_repo/waterdeath4.png", width, height, true, true);
		Image death5 = new Image("file:src/p4_group_8_repo/waterdeath5.png", width, height, true, true);
		
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				this.death++;
			}
			if (this.death == 1) {
				setImage(death1);
			}
			else if (this.death == 2) {
				setImage(death2);
			}
			else if (this.death == 3) {
				setImage(death3);
			}
			else if (this.death == 4) {
				setImage(death4);
			}
			else if (this.death == 5) {
				setX(300);
				setY(679.8+movementY);
				waterDeath = false;
				this.life--;	//decrease one life
				this.changeLife = true;
				this.death = 0;
				setImage(death5);
				noMove = false;
				if (this.points>50) {
					this.points-=50;
					this.changeScore = true;
				}
			}
			
		}
		return waterDeath;
	}
	
	/**
	* This is the method to run when intersection occurs between the frog and obstacle.
	* @since 1.0.1
	*/
	public void Intersection() {
		double speed;	//create this variable to get the speed of the actor intersection with
		// so the frog can move at the same speed
		if (getIntersectingObjects(CarObstacle.class).size() >= 1) {	//intersect with car
			this.carDeath = true;
		}
		else if (getIntersectingObjects(TruckObstacle.class).size() >= 1) {	//intersect with truck
			this.carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {	//intersect with log
			speed = getIntersectingObjects(Log.class).get(0).getSpeed();
			move (speed, 0);	//display as moving together with log
			if (getIntersectingObjects(Snake.class).size() >= 1) {	//intersect with snake
				this.waterDeath = true;
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {	//intersect with turtle
			speed = getIntersectingObjects(Turtle.class).get(0).getSpeed();
			move(speed, 0);	//display as moving together with turtle
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {	//intersect with wet turtle
			speed = getIntersectingObjects(WetTurtle.class).get(0).getSpeed();
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				this.waterDeath = true;
			} else {
				move(speed, 0);	//display as moving together with wet turtle
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {	//intersect with the end slot
			if (getIntersectingObjects(End.class).get(0).isActivated()) {	//if the slot is unavailable
				this.end--;
				this.points-=110;	// remove the previous frog results if it enter the non-empty slot
				this.points-=50;	// remove the add 50 points for getting into a non-empty slot
			}
			this.points+=50;	//so there is no increment or decrement in points if frog enter slot is not available
			this.w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			this.end++;
			setX(300);
			setY(679.8+movementY);
		}
		else if (getY()<413){	//frog drop into water
			this.waterDeath = true;
		}
	}
	
	/**
	* This is the method to set movement of frog.
	* @since 1.0.4
	* @param noMove The value to set the movement of frog.
	*/
	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}
	
}
