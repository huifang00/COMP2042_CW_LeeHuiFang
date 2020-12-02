package p4_group_8_repo.backgroundfunction;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import p4_group_8_repo.actor.Actor;

/**
* World Class
* Abstract class which contains the method that relevant of each inherited subclass.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public abstract class World extends Pane {
    private AnimationTimer timer;
    private static BorderPane root;
    
    /**
	 * Constructor to pass in the value of Border Pane which is created using the Scene Builder.
	 * This allows actor(s) to be added without using the Scene Builder such as for the function of game which is the backend.
	 * @param root The variable of Border Pane which is created using the Scene Builder.
	 * @since 1.0.1
	 */
    public World(BorderPane root) {
    	World.root = root;
    	Scene newValue = root.getScene();
    	//when keyboard key is pressed
    	newValue.setOnKeyPressed(event -> {
    		if(getOnKeyPressed() != null) 
    			getOnKeyPressed().handle(event);
    		List<Actor> myActors = getObjects(Actor.class);
    		for (Actor anActor: myActors) {
    			if (anActor.getOnKeyPressed() != null) {
    				anActor.getOnKeyPressed().handle(event);
    			}
    		}			
    	});
    	//when the pressed key is released
    	newValue.setOnKeyReleased(event -> {
    		if(getOnKeyReleased() != null) 
    			getOnKeyReleased().handle(event);
    		List<Actor> myActors = getObjects(Actor.class);
    		for (Actor anActor: myActors) {
    			if (anActor.getOnKeyReleased() != null) {
    				anActor.getOnKeyReleased().handle(event);
    			}
    		}
    	});
    	
    }
    
	/**
	* This is the method to create animation timer and handle() method is called in every frame of the animation.
	* This method saves the object created/inherited from actor class to a list.
	* @since 1.0
	*/
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
	* This is the method to create and start the animation timer.
	* @since 1.0
	*/
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
	* This is the method to stop the animation timer.
	* @since 1.0
	*/
    public void stop() {
        timer.stop();
    }
    
    /**
     * This is the method to add the object of actor class to the application.
     * @param actor The object of actor class to be added to the application.
     * @since 1.0
     */
    public void add(Actor actor) {
        root.getChildren().add(actor);
    }

    /**
     * This is the method to remove the object of actor class from the application.
     * @param actor The object of actor of class to be removed from the application.
     * @since 1.0
     */
    public void remove(Actor actor) {
        root.getChildren().remove(actor);
    }

    /**
     * This is the method to get the list of object(s) of actor class.
     * @param <A> The type of the actor class modeled by actor object.
     * @param cls The class object corresponding to Actor type.
     * @return A This returns the array which contains the list of object(s) of class extended from actor class. 
     * @since 1.0
     */
    public static <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: root.getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
  	* This is the abstract method for actor performing an action and must included in each concrete subclass(es).
  	* @param now The time stamp of the current frame given in nanoseconds.
  	* @since 1.0
  	*/
    public abstract void act(long now);
}
