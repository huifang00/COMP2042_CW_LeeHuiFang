#COMP2042_CW_LeeHuiFang
This project is about maintaining and extending on a classic retro game(Frogger).

##Maintenance

1.The preserveratio as the parameter of Image constructor for BackgroundImage and Digit is set to false.
	-The image can appear nicer than previous as the ratio of the image in these classes does not affect much.
2.Create new method without affectin the function.
	-The code look neater as a method does not contain bunches of code.
3.Edit the intersection method by adding speed variable to get the speed of obstacle intersected.
	-Relevant code such as getLeft() are removed as the moving direction can be known by getting the speed.
4.Changes in variable
	a)Access modifier of variable(s) are changed to private
		-Setter & getter method are created to access the variable
		-This is to hides the data from other classes.
	b)The global variables in each class are grouped by their datatype.
		-The code looks neater and easier to understand.
	c)Change the datatype of size to double as it is more accurate and the superclass return the size in double.
	d)The variable imgsize as input of parameter to constructor is separated into width and height as not all images are square.
	e)Declare private variable width and height in class End
		-Frog placed in the slot have the same size as the slot and always depends on slot size.
	f)Rename the variable to a more understandable way such as carD is renamed to death. 
	g)Create new variables with datatype of ArrayList for image in Life and Digit classes to save the actor added on the interface.
		-Therefore, deletion of the actor(s) can be done easily.
5.Edit the background images because previously the stated filename does not exist.

6.Remove the bugs on point system to prevent confusion on points calculation.
	Eg.The source code counts a step to a slot which is unavailable is a successful step.
7.Constructor in each class.
	a)Create a default constructor for each class. Therefore, objects can be initialized as error happens if no object is used to compare in a condition.
	b)Position(s) of image are set as a parameter to the constructor.
		-As a parameter, future editing is possible while creating the constructor.
	c)Remove parameter in the constructor for classes that extend actor class.
		-The link image of images are removed as a parameter to the constructor.
		-They are initialized in the constructor when the constructor is called.
	d)Rename parameter(s) of constructor.
		-By renaming the parameter(s), they are more understandable, such as s is renamed to speed.
	e)Change the datatype of parameter(s) to double as it is more accurate than integer.
	f)Edit on variable and sequence of parameter for constructors uniformly to prevent confusion in future.
8.Remove unused code.
	-Remove unused variable from the source code.
	-Remove condition which will never occured.
9.Edit the conditions and statement in the act method.
	-This is because some actor(s) are having different sizes.
	-By editing on the condition and staements, the actors can moved more naturally.
10.Remove unwanted spacing and indentation in the code.
	-This it to make the code looks neater and more easier to read.
11.Adding comments and removing unwanted comments.
	-Unused code which is commented are removed because not everyone will understand the usage of commented code.


##Extension

1.Create a menu
	-Create Play and How To Play functions
2.Get the player name and set the limitation(s).
3.Create level classes	
	-Create method to add and remove obstacles in each level classes so it looks neater.
	-Easier to maintain the code in future if each level has own class as each level is having different functions.
4.Create a life function, life is deducted if frog hits an obstacle.
5.Create new function to the frogger 
	-Create a instruction button to get the instruction while game playing
	-Create a function to pause or resume while playing frogger.
	-Create a function on play or mute the background music
6.Display the score of previous level at the end of each level and ask whether to proceed to next level.
7.Save the score of the player with name in a text file 
8.Edit the interface design
	-Showing what is the current level playing