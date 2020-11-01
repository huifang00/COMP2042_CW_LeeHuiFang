package p4_group_8_repo;

public class Level2{
	
	Animal animal;
	Log log1, log2, log3, log4, log5, log6, log7, log8;
	Turtle turtle1, turtle2;
	WetTurtle weturtle1, weturtle2, weturtle3, weturtle4;
	End end1, end2, end3, end4, end5;
	CarObstacle carobstacle1, carobstacle2, carobstacle3, carobstacle4, carobstacle5, carobstacle6;
	TruckObstacle truckobstacle1, truckobstacle2, truckobstacle3, truckobstacle4, truckobstacle5;
	
	public Level2(MyStage background, Animal animal) {
		addLog(background);
		addTurtle(background);
		addEnd(background);
		addAnimal(background, animal);
		addObstacle(background);
	}
	
	public void addLog(MyStage background) {
		log1 = new Log(2, 0, 166, 0.75);	//1.25
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
    }
    
    public void addAnimal(MyStage background, Animal animal) {
    	this.animal = animal;
    	background.add(animal);
    }
    
    public void addObstacle(MyStage background) {
    	addCarObstacle(background);
    	addTruckObstacle(background);
    }
    
    public void addCarObstacle(MyStage background) {
    	carobstacle1 = new CarObstacle(100, 597, -2);	//previous -1(L1)
    	background.add(carobstacle1);
    	carobstacle2 = new CarObstacle(250, 597, -2);
    	background.add(carobstacle2);
    	carobstacle3 = new CarObstacle(400, 597, -2);
    	background.add(carobstacle3);
    	carobstacle4 = new CarObstacle(550, 597, -2);
    	background.add(carobstacle4);
    	carobstacle5 = new CarObstacle(500, 490, -5);
    	background.add(carobstacle5);
    	carobstacle6 = new CarObstacle(150, 490, -5);	//previous no
    	background.add(carobstacle6);
    }
    
    public void addTruckObstacle(MyStage background) {
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
		background.remove(animal);
    }
    
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

