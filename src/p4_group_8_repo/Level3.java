package p4_group_8_repo;

/**
* Level2 Class
* Class which includes all the actor(s) or images(s) for level 3.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public class Level3{
	
	Animal animal;
	Log log1, log2, log3, log4, log5, log6, log7, log8;
	Turtle turtle1, turtle2;
	WetTurtle weturtle1, weturtle2, weturtle3, weturtle4;
	End end1, end2, end3, end4, end5;
	CarObstacle carobstacle1, carobstacle2, carobstacle3, carobstacle4, carobstacle5;
	TruckObstacle truckobstacle1, truckobstacle2, truckobstacle3, truckobstacle4, truckobstacle5, truckobstacle6;
	LevelImage levelImage;
	private int score = 0;
	MyStage background;
	
	/**
	 * Class constructor which calls the method(s) to create image(s) in the application.
	 * @param background The stage of the game application where it contain all actors.
	 */
	public Level3(MyStage background, Animal animal) {
		this.background = background;
		this.animal = animal;
		addLevelImage();
		addLog();
		addTurtle();
		addEnd();
		addAnimal();
		addObstacle();
	}
	
	/**
	 * Default constructor
	 */
	public Level3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is the method to add the image of level information.
	 */
	public void addLevelImage() {
		levelImage = new LevelImage(3, 10, 40, 130, 130);
		background.add(levelImage);
	}

	/**
	 * This is the method to add the image(s) of log.
	 */
	public void addLog() {
		log1 = new Log(1, 0, 166, 2, 150, 150);
    	background.add(log1);
    	log2 = new Log(1, 220, 166, 2, 150, 150);
    	background.add(log2);
    	log3 = new Log(1, 440, 166, 2, 150, 150);
    	background.add(log3);
    	log4 = new Log(2, 0, 276, -2.5, 300, 300);
    	background.add(log4);
    	log5 = new Log(2, 400, 276, -2.5, 300, 300);
    	background.add(log5);
    	log6 = new Log(1, 50, 329, 3, 150, 150);
    	background.add(log6);
    	log7 = new Log(1, 270, 329, 3, 150, 150);
    	//background.add(log7);
    	log8 = new Log(2, 400, 329, 3, 300, 300);
    	background.add(log8);
    }

	/**
	 * This is the method to add the image(s) of wet turtle.
	 */
    public void addTurtle() {
    	turtle1 = new Turtle(500, 376, -2.5, 130, 130);	
    	background.add(turtle1);
    	turtle2 = new Turtle(300, 376, -2.5, 130, 130);
    	background.add(turtle2);
    	weturtle1 = new WetTurtle(700, 376, -2.5, 130, 130);
    	background.add(weturtle1);
    	weturtle2 = new WetTurtle(100, 217, 1.5, 130, 130);//-1
    	background.add(weturtle2);
    	weturtle3 = new WetTurtle(400, 217, 1.5, 130, 130);
    	background.add(weturtle3);
    	weturtle4 = new WetTurtle(700, 217, 1.5, 130, 130);
    	background.add(weturtle4);
    	
    }
    
    /**
     * This is the method to add the image(s) of empty slot.
     */
    public void addEnd() {
    	end1 = new End(13, 96, 60, 60);
    	background.add(end1);
    	end2 = new End(141, 96, 60, 60);
    	background.add(end2);
    	end3 = new End(141 + 141-13, 96, 60, 60);
    	background.add(end3);
    	end4 = new End(141 + 141-13+141-13+1, 96, 60, 60);
    	background.add(end4);
    	end5 = new End(141 + 141-13+141-13+141-13+3, 96, 60, 60);
    	background.add(end5);
    }
    
    /**
     * This is the method to add the image of frog as the main character in the application.
     */
   public void addAnimal() {
    	background.add(animal);
    }
   
   /**
    * This is the method to add the image(s) of car and truck as obstacle(s).
    */
    public void addObstacle() {
    	addCarObstacle();
    	addTruckObstacle();
    }

    /**
     * This is the method to add the image(s) of car as obstacle(s).
     */
    public void addCarObstacle() {
    	carobstacle1 = new CarObstacle(200, 597, -3, 50, 50);	//previous -1(L1)
    	background.add(carobstacle1);
    	carobstacle2 = new CarObstacle(400, 597, -3, 50, 50);
    	background.add(carobstacle2);
    	carobstacle3 = new CarObstacle(600, 597, -3, 50, 50);
    	background.add(carobstacle3);
    	carobstacle4 = new CarObstacle(500, 490, -5, 50, 50);
    	background.add(carobstacle4);
    	carobstacle5 = new CarObstacle(300, 540, 1, 50, 50);
    	background.add(carobstacle5);
    }

    /**
     * This is the method to add the image(s) of truck as obstacle(s).
     */
    public void addTruckObstacle() {
    	truckobstacle1 = new TruckObstacle(1, 0, 649, 1, 120, 120);
    	background.add(truckobstacle1);
    	truckobstacle2 = new TruckObstacle(1, 300, 649, 1, 120, 120);
    	background.add(truckobstacle2);
    	truckobstacle3 = new TruckObstacle(1, 600, 649, 1, 120, 120);
    	background.add(truckobstacle3);
    	truckobstacle4 = new TruckObstacle(2, 0, 540, 1, 200, 200);
    	background.add(truckobstacle4);
    	truckobstacle5 = new TruckObstacle(2, 500, 540, 1, 200, 200);
    	background.add(truckobstacle5);
    	truckobstacle6 = new TruckObstacle(1, 150, 490, -5, 120, 120);
    	background.add(truckobstacle6);
    }

    /**
     * This is the method to remove the image(s) in the application.
     */
    public void remove() {
    	removeLevelImage();
    	removeLog();
    	removeTurtle();
    	removeEnd();
    	removeAnimal();
    	removeCarObstacle();
    	removeTruckObstacle();
    }
    
    /**
     * This is the method to remove the image of level information.
     */
    public void removeLevelImage() {
    	background.remove(levelImage);
    }

    /**
     * This is the method to remove the image(s) of log.
     */
    public void removeLog() {
    	background.remove(log1);
    	background.remove(log2);
    	background.remove(log3);
    	background.remove(log4);
    	background.remove(log5);
    	background.remove(log6);
    	background.remove(log7);
    	background.remove(log8);
    }

    /**
     * This is the method to add the image(s) of turtle.
     */
    public void removeTurtle() {
    	background.remove(turtle1);
    	background.remove(turtle2);
    	background.remove(weturtle1);
    	background.remove(weturtle2);
    	background.remove(weturtle3);
    	background.remove(weturtle4);
    	
    }

    /**
     * This is the method to add the image(s) of empty slot.
     */
    public void removeEnd() {
    	background.remove(end1);
    	background.remove(end2);
    	background.remove(end3);
    	background.remove(end4);
    	background.remove(end5);
    }
    
    /**
     * This is the method to remove the image of frog as the main character in the application.
     */
    public void removeAnimal() {
		background.remove(animal);
    }
    
    /**
     * This is the method to remove the image(s) of car as obstacle(s).
     */
    public void removeCarObstacle() {
    	background.remove(carobstacle1);
    	background.remove(carobstacle2);
    	background.remove(carobstacle3);
    	background.remove(carobstacle4);
    	background.remove(carobstacle5);
    }

    /**
     * This is the method to remove the image(s) of truck as obstacle(s).
     */
    public void removeTruckObstacle() {
    	background.remove(truckobstacle1);
    	background.remove(truckobstacle2);
    	background.remove(truckobstacle3);
    	background.remove(truckobstacle4);
    	background.remove(truckobstacle5);
    	background.remove(truckobstacle6);
    }

    /**
     * This is the method to set the score which player get for level 3.
     * @param score The score which player get for level 3.
     */
    public void setScore(int score) {
    	this.score = score;
    }

    /**
     * This is the method to get the score of level 3 which player achieved.
     * @return int This returns the score of level 3 which player achieved.
     */
    public int getScore() {
    	return score;
    }
}

