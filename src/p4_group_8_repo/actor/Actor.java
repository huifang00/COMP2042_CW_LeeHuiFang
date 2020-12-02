package p4_group_8_repo.actor;

import javafx.scene.image.ImageView;
import p4_group_8_repo.backgroundfunction.World;

import java.util.ArrayList;

/**
* Actor Class
* Abstract class which contains the method that relevant of each inherited subclass.
* This class creates an image on the application.
*
* @author  Lee Hui Fang 20125427, hfyhl2
* @since   1.0
*/
public abstract class Actor extends ImageView{

	/**
	* This is the method for the increment of step of frog.
	* @param dx The step of frog moving horizontally.
	* @param dy The step of frog moving vertically.
	* @since 1.0
	*/
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    
    /**
	* This is the method to get width value.
	* @return double This returns the width of the node.
	* @since 1.0
	*/
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
	* This is the method to get height value.
	* @return double This returns the height of the node.
	* @since 1.0
	*/
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * This is the method for intersection occurs between more than 2 objects.
     * @param <A> The type of the actor class modeled by actor object.
     * @param cls The class object corresponding to Actor type.
     * @return A This returns the array which contains the list of object(s) of class extended from actor class. 
     * @since 1.0
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: World.getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
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
