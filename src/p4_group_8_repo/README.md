# COMP2042_CW_LeeHuiFang
This project is about maintaining and extending on a classic retro game(Frogger).

## Maintenance

1. Remove/Edit bugs
	<ol type="i">
		<li>Edit the image link which is not existed.</li>
		<li>Edit the point calculation system.</li>
		eg. Step to a unavailable slot is not a successful step.
	</ol>
2. Create new method without affecting the application function so the code looks neater and less complicated.
		
3. Set false to preserveratio image(s) so the image appeared nicer and clearer.
	
4. Edit intersection method by adding speed variable to get the speed of obstacle intersected.
	- Relevant code such as getLeft() are removed as the moving direction can be known by getting the speed.
	
5. Changes in variable
	<ol type="i">
		<li>Access modifier of variables are changed to private to hides the data. Setter & getter method are created if needed.</li>
		<li>The variables are grouped according to datatype, so code looks neater.</li>
		<li>Change the datatype of size to double as double is more accurate and the superclass return the size in double.</li>
		<li>The variable imgsize is splitted into width and height as not all images are square shaped.</li>
		<li>Declare private variable width and height in class End, so the images placed at the same position having equal size.</li>
		<li>Rename the variable, so the code can be easily understand.</li>
		<li>Create new ArrayList variables to save the actor added on the interface, so delettion can be done easily.</li>
	</ol>
	
6. Constructor in each class.
	<ol type="i">
		<li>Position of image are set as parameter, so code maintenance is easier.</li>
		<li>Remove unused parameter from constructor, so the code more understandable and prevent confusion.</li>
		<li>Rename parameters of constructor, so the code is more understandable.</li>
		<li>Change the datatype of parameters to double as it is more accurate.</li>
		<li>Edit the sequence of parameter, so constructor with similar usage looks uniform.</li>
	</ol>
	
8. Remove unused code such as commented codes, unused variable and condition never met.
	
9. Edit spacing and indentation(s), so it looks neater and more easier to read.
	
10. Add comments & create javadocs so the code easier to understand by others.

11. Split the files into respective packages and remove unwanted package(s).

12. Create class for each level. Therefore, code maintenance is easier as each level is unique.

13. Apply Factory Design Pattern so the creation logic of object(s) is hidden to the client.

14. Apply MVC Pattern which divides the program into Model, View and Controller. Therefore, the logic on front-end and back-end is separated.

15. Use JavaFX Scene Builder to deal with the interface.

16. Junit tests are created to ensure that the classes or methods created have no errors. And this project is also builded using Ant.

17. Use lambda functions

## Extension

1. Create a menu(Play & Instruction & HighScore), so player knows how the application works.

2. Get the player name and set the limitations.
	
3. Create a life function, life is deducted if frog hits an obstacle.

4. Create function on displaying instruction during game, pause/resume game and mute/play background music.
	
5. Display the score of previous level at the end of each level and ask whether to proceed to next level.

6. Save the score of the player with name in a text file. 

7. Display information needed on the interface.

## Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)