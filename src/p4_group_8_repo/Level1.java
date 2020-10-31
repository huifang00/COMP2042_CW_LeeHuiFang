package p4_group_8_repo;

public class Level1 extends Level{
	
	Animal animal;
	Log log1, log2, log3, log4, log5, log6, log7, log8;
	Turtle turtle1, turtle2;
	WetTurtle weturtle1, weturtle2, weturtle3, weturtle4;
	End end1, end2, end3, end4, end5;
	CarObstacle carobstacle1, carobstacle2, carobstacle3, carobstacle4, carobstacle5;
	TruckObstacle truckobstacle1, truckobstacle2, truckobstacle3, truckobstacle4, truckobstacle5;
	
	public Level1(MyStage background) {
		addLog(background);
		addTurtle(background);
		addEnd(background);
		addAnimal(background);
		addObstacle(background);
	}
	
	public void setStartImage(MyStage background) {
    	Start start = new Start(250,350);
		background.add(start);
    }
	
	public void addLog(MyStage background) {
    	/*
    	background.add(new Log("file:src/p4_group_8_repo/log3.png", 0, 166, 0.75, 150, 150));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 220, 166, 0.75, 150, 150));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 440, 166, 0.75, 150, 150));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 0, 166, 0.75, 150, 150));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 0, 276, -2, 300, 300));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 400, 276, -2, 300, 300));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 800, 276, -2, 300, 300));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 50, 329, 0.75, 150, 150));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 270, 329, 0.75, 150, 150));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 490, 329, 0.75, 150, 150));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 570, 329, 0.75, 150, 150));
		 */
    	//Log log1, log2, log3, log4, log5, log6, log7, log8;
    	
    	
    	log1 = new Log(2, 0, 166, 0.75);
    	background.add(log1);
    	log2 = new Log(2, 220, 166, 0.75);
    	background.add(log2);
    	log3 = new Log(2, 440, 166, 0.75);
    	background.add(log3);
    	log4 = new Log(1, 0, 276, -2);
    	background.add(log4);
    	log5 = new Log(1, 400, 276, -2);
    	background.add(log5);
    	log6 = new Log(2, 50, 329, 0.75);
    	background.add(log6);
    	log7 = new Log(2, 270, 329, 0.75);
    	background.add(log7);
    	log8 = new Log(2, 490, 329, 0.75);
    	background.add(log8);
    }
    
    public void addTurtle(MyStage background) {
    	/*
    	background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		*/
    	//Turtle turtle1, turtle2;
    	//WetTurtle weturtle1, weturtle2, weturtle3, weturtle4;
    	turtle1 = new Turtle(500, 376, -1);
    	background.add(turtle1);
    	turtle2 = new Turtle(300, 376, -1);
    	background.add(turtle2);
    	weturtle1 = new WetTurtle(700, 376, -1);
    	background.add(weturtle1);
    	weturtle2 = new WetTurtle(600, 217, -1);
    	background.add(weturtle2);
    	weturtle3 = new WetTurtle(400, 217, -1);
    	background.add(weturtle3);
    	weturtle4 = new WetTurtle(200, 217, -1);
    	background.add(weturtle4);
    	
    }
    
    public void addEnd(MyStage background) {
    	//End end1, end2, end3, end4, end5;
    	end1 = new End(13, 96);
    	background.add(end1);
    	end2 = new End(141,96);
    	background.add(end2);
    	end3 = new End(141 + 141-13, 96);
    	background.add(end3);
    	end4 = new End(141 + 141-13+141-13+1, 96);
    	background.add(end4);
    	end5 = new End(141 + 141-13+141-13+141-13+3, 96);
    	background.add(end5);
    	/*
    	background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		*/
    }
    
    public void addAnimal(MyStage background) {
    	//animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
    	animal = new Animal(300, 679.8+(13.3333333*2));
		background.add(animal);
    }
    
    public void addObstacle(MyStage background) {
    	addCarObstacle(background);
    	addTruckObstacle(background);
    	/*
    	background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));
		*/
    }
    
    public void addCarObstacle(MyStage background) {
    	//CarObstacle carobstacle1, carobstacle2, carobstacle3, carobstacle4, carobstacle5;
    	carobstacle1 = new CarObstacle(100, 597, -1);
    	background.add(carobstacle1);
    	carobstacle2 = new CarObstacle(250, 597, -1);
    	background.add(carobstacle2);
    	carobstacle3 = new CarObstacle(400, 597, -1);
    	background.add(carobstacle3);
    	carobstacle4 = new CarObstacle(550, 597, -1);
    	background.add(carobstacle4);
    	carobstacle5 = new CarObstacle(500, 490, -5);
    	background.add(carobstacle5);
    }
    
    public void addTruckObstacle(MyStage background) {
    	TruckObstacle truckobstacle1, truckobstacle2, truckobstacle3, truckobstacle4, truckobstacle5;
    	truckobstacle1 = new TruckObstacle(1, 0, 649, 1);
    	background.add(truckobstacle1);
    	truckobstacle2 = new TruckObstacle(1, 300, 649, 1);
    	background.add(truckobstacle2);
    	truckobstacle3 = new TruckObstacle(1, 600, 649, 1);
    	background.add(truckobstacle3);
    	truckobstacle4 = new TruckObstacle(2, 0, 540, 1);
    	background.add(truckobstacle4);
    	truckobstacle5 = new TruckObstacle(2, 500, 540, 1);
    	background.add(truckobstacle5);
    }
    
    public void remove(MyStage background) {
    	removeLog(background);
    	removeTurtle(background);
    	removeEnd(background);
    	removeAnimal(background);
    	removeCarObstacle(background);
    	removeTruckObstacle(background);
    }
    public void removeLog(MyStage background) {
    	background.remove(log1);
    	background.remove(log2);
    	background.remove(log3);
    	background.remove(log4);
    	background.remove(log5);
    	background.remove(log6);
    	background.remove(log7);
    	background.remove(log8);
    }
    
    public void removeTurtle(MyStage background) {
    	background.remove(turtle1);
    	background.remove(turtle2);
    	background.remove(weturtle1);
    	background.remove(weturtle2);
    	background.remove(weturtle3);
    	background.remove(weturtle4);
    	
    }
    
    public void removeEnd(MyStage background) {
    	background.remove(end1);
    	background.remove(end2);
    	background.remove(end3);
    	background.remove(end4);
    	background.remove(end5);
    }
    
    public void removeAnimal(MyStage background) {
    	//animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
    	animal = new Animal(300, 679.8+(13.3333333*2));
		background.remove(animal);
    }
    /*
    public void removeObstacle(MyStage background) {
    	removeCarObstacle(background);
    	removeTruckObstacle(background);
    }
    */
    
    public void removeCarObstacle(MyStage background) {
    	background.remove(carobstacle1);
    	background.remove(carobstacle2);
    	background.remove(carobstacle3);
    	background.remove(carobstacle4);
    	background.remove(carobstacle5);
    }
    
    public void removeTruckObstacle(MyStage background) {
    	background.remove(truckobstacle1);
    	background.remove(truckobstacle2);
    	background.remove(truckobstacle3);
    	background.remove(truckobstacle4);
    	background.remove(truckobstacle5);
    }
    
}

