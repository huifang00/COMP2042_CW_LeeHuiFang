# COMP2042_CW_LeeHuiFang
This project is about maintaining and extending a re-implementation of a classic retro game(Frogger).

## Maintenance
### 1. The preserveratio as the parameter of Image constructor for BackgroundImage and Digit is set to false.
	- So the background image can fit into the window
	- So the digit appeared in the same size by getting the size of given by programmer
### 2. Create carDeath, waterDeath & Intersection method in Animal.java.
	- The code look more tidy than previous as not all code is in act method
### 3. Edit the intersection method by adding speed variable to get the speed of obstacle intersected.
	- getLeft() is removed as the moving direction can be known by getting the speed
	- if else condition for getting the direction of moving is removed
### 4. Changes in variable
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

### 5. Edit the background images
	- Edit the coding of adding background image because previously the stated filename does not exist in the folder
### 6. Remove the bugs existed in the source code provided.
	a) The point system of the source code has bug on increasing 10points for each successful step to upward.
		- However, the source code counts a step to a slot which is unavailable is a successful step too.
		- Also, if the frog enter a non-empty slot, the calculation of points is restart as a new frog is created rather than the same as the previous.
		- Hence, to remove these bugs, 110points is deducted if the frog enters a non-empty slot.
			- 10points is removed for counting the last step to the non-empty slot as a successful step and 
			  the 100points is removed as it is the max of points of crossing all obstacles.
		- After editing, the point remains unchanged if the frog is inserted into a non-empty slot.
		

## Extension
### 1. Create a menu
	- Include the Play and How to Play Button
	- Player can understand the instruction on playing Frogger
### 2. Get the player name	
	- Limitation on creating a name:
		i) Cannot have the same name as other player
		ii) Cannot exceed 18characters
		iii) Cannot be blank
		iv) Cannot contains special character
### 3. Create level classes	
	- Create the difficulty of frogger up to level 3 by changing the speed of obstacles
### 4. Create a life function
	- In order to make Frogger more interesting
	- Frog hits a car, truck or falls into river will cause life decuted by one.
### 5. Create new function to the frogger 
	a) Create a instruction button to get the instruction while game playing
		- Player can easily access the instruction function.
		- A dialog is shown if the button is clicked and the game is paused.
	b) Create a function to pause or resume while playing frogger.
		- A pause/resume button is added onto the interface.
		- If the pause button is clicked, the game include the background music is paused.
			And the button is replaced with the resume button.
		- If the resume button is clicked, the game and background music is continue played.
			And the button is replaced with the pause button.
	c) Create a function on play or mute the background music
		- A volume on/off button is added onto the interface. 
	
### 6. Display the score of previous level at the end of each level
	- A dialog will pop up with the score ahieved by played level
	- This dialog will ask player whether to proceed to next level
### 7. Save the score of the player with name in a text file 