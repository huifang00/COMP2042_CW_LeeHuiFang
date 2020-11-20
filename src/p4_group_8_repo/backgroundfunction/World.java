package p4_group_8_repo.backgroundfunction;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import p4_group_8_repo.actor.Actor;

/**
* World Class
* Abstract class which contains the method that relevant of each inherited subclass.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
	* This is the method to create animation and handle() method is called in every frame of the animation.
	* This method save the object created/inherited from actor class to a list.
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
	*/
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
	* This is the method to stop the animation timer.
	*/
    public void stop() {
        timer.stop();
    }
    
    /**
     * This is the method to add the object of actor class to the application..
     * @param actor The object of actor class to be added to the application.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * This is the method to remove the object of actor class from the application..
     * @param actor The object of actor of class to be removed from the application.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * This is the method get the list of object(s) of actor class.
     * @param <A> The type of the actor class modeled by actor object
     * @param cls The class object corresponding to Actor type.
     * @return ArrayList<A> This returns the array which contains the list of object(s) of actor class.
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
  	* This is the abstract method for actor performing an action and must included in each concrete subclass(es).
  	*/
    public abstract void act(long now);
}
