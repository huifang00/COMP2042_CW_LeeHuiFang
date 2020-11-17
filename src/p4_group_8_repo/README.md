# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)

# COMP2042_CW_LeeHuiFang
This project is about maintaining and extending on a classic retro game(Frogger).

## Maintenance

1. Remove/Edit bugs
	a) Edit the image link which is not existed.
	b) Edit the point calculation system.
		eg. Step to a unavailable slot is not a successful step.
		
2. Create new method without affecting the application function.
	- Therefore, code looks neater and less complicated.
		
3. Set false to preserveratio of background and digit image
	- The images appeared nicer and cleaner.
	
4. Edit intersection method by adding speed variable to get the speed of obstacle intersected.
	- Relevant code such as getLeft() are removed as the moving direction can be known by getting the speed.
	
5. Changes in variable
	a) Access modifier of variables are changed to private to hides the data.
		- Setter & getter method are created if needed.
	b) The variables are grouped according to datatype, so code looks neater.
	c) Change the datatype of size to double as double is more accurate and the superclass return the size in double.
	d) The variable imgsize is splitted into width and height as not all images are square shaped.
	e) Declare private variable width and height in class End, so the images placed at the same position having equal size.
	f) Rename the variable, so the code can be easily understand.
	g) Create new ArrayList variables to save the actor added on the interface.
		- Therefore, deletion of the actors can be done easily.
	
6. Constructor in each class.
	a) Create default constructor to prevent error happens.
	b) Position of image are set as parameter, so code maintenance is easier.
	c) Remove parameter from constructor.
		- Image link is not needed as parameter and images are initialized in the constructor.
	d) Rename parameters of constructor, so the code is more understandable.
		eg. s is renamed to speed.
	e) Change the datatype of parameters to double as it is more accurate.
	f) Edit on variable and sequence of parameter, so constructor with similar usage looks uniform.
	
8. Remove unused code.
	- Remove unused variable and condition never met.
	
9. Remove unwanted spacing and indentation, so it looks neater and more easier to read.
	
10. Adding comments and removing unwanted comments such as commented codes to avoid confusion.
	
11. Factory Design Pattern is applied on creating object of obstacles.

12. Split the files into respective packages.

13. Create class for each level.
	- Therefore, code maintenance is easier as each level is unique.

## Extension

1. Create a menu(Play & Instruction & HighScore), so player knows how the game works.

2. Get the player name and set the limitations.
	
3. Create a life function, life is deducted if frog hits an obstacle.

4. Create function on displaying instruction during game, pause/resume game and mute/play background music.
	
5. Display the score of previous level at the end of each level and ask whether to proceed to next level.

6. Save the score of the player with name in a text file 

7. Display information needed on the interface
