# COMP2042_CW_LeeHuiFang
This project is about maintaining and extending a re-implementation of a classic retro game(Frogger).

## Maintenance
1. The preserveratio as the parameter of Image constructor for BackgroundImage and Digit is set to false.
	- So the background image can fit into the window
	- So the digit appeared in the same size by getting the size of given by programmer
2. Create carDeath, waterDeath & Intersection method in Animal.java.
	- The code look more tidy than previous as not all code is in act method
3. Edit the intersection method by adding speed variable to get the speed of obstacle intersected.
	- getLeft() is removed as the moving direction can be known by getting the speed
	- if else condition for getting the direction of moving is removed
4. Changes in variable
	a) Access modifier of variable(s) are changed to private instead of default
		- setter & getter method are created for class that need to access the variable
	b) Speed variable in each actor class
		- Change the name of parameter of s to speed, as this is more understandable
		- Change the datatype to double as can do more changes on speed with dataype double
	c) imgsize variable as input of parameter to constructor of subclasses inherit from Actor
		- Instead of having one variable for the size of image, it is separated into width and height as not all images are square
		- Change the datatype to double as the method getWidth and getHeight in Actor(Superclass) return double
	d) dim variable in class Digit
		- Instead of setting the size in the class, set it as input parameter to the constructor
		- Hence, the variable declared can be removed
	e) Declare private variable width and height in class End
		- These variables can be only editted in End constructor for the slot size.
		- The image of frog placed in the slot have the same size as the slot and it always depends on the size of slot
	f) Change the name of carD in class Animal to death
		- Name death is more understandable as it will changed when frog hits a car/truck or falls into river.

5. 

## Extension
1. Create a menu
	- Include the Play and How to Play Button
	- Player can understand the instruction on playing Frogger
2. Create a instruction button to get the instruction while game playing
	- Player can easily access the instruction function.
	- A dialog is shown if the button is clicked.
3. Get the player name
	- Limitation on creating a name:
		i) Cannot have the same name as other player
		ii) Cannot exceed 18characters
		iii) Cannot be blank
		iv) Cannot contains special character
4. Save the score of the player with name in a text file 
5. Create a life function
	- In order to make Frogger more interesting
	- Frog hits a car, truck or falls into river will cause life decuted by one.
6. Create level classes	
7. Display the score of previous level at the end of each level
	- A dialog will pop up with the score ahieved by played level
	- This dialog will ask player whether to proceed to next level