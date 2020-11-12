package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
* FROGGER
* The Frogger application is a game that helps the frog to cross the traffic and river.
* 
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @version 1.0
* @since   2020-12-12
*/
public abstract class Actor extends ImageView{

	/**
	* This is the method for the increment of step of frog.
	* @param dx The step of frog moving horizontally.
	* @param dy The step of frog moving vertically.
	*/
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
	* This is the method get the value of the property parent.
	* @return World This return the node that added to the scene.
	*/
    public World getWorld() {
        return (World) getParent();
    }

    /**
	* This is the method get width value.
	* @return double This returns the width of the node .
	*/
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
	* This is the method get height value.
	* @return double This returns the height of the node .
	*/
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
	* This is the method intersection occurs between more than 2 objects.
	* @return ArrayList This returns the array of objects which involve in the intersection.
	*/
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /*can remove if not used this is from source code
    public void manageInput(InputEvent e) {
        
    }
	*/
    
    /**
	* This is the method intersection occurs between 2 objects.
	* @return ArrayList This returns the array of the 2 objects which involve in the intersection.
	*/
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    /**
	* This is the abstract method for actor performing an action.
	*/
    public abstract void act(long now);

}
