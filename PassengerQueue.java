/**
 * This class makes a passengerqueue which is going to have a queue of passenger objects
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */

import java.util.ArrayList;

public class PassengerQueue {
    public ArrayList<Passenger> queue = new ArrayList<Passenger>();

    /**
     * This creates a default passengerqueue object
     */
    public PassengerQueue() {

    }

    /**
     * This method takes a passenger object as a parameter and adds it to an arraylist which will act as a queue
     * @param p
     */
    public void enqueue(Passenger p) {
        queue.add(p);
    }

    /**
     * This method removes a passenger object from the arraylist
     * @return Passenger
     */
    public Passenger dequeue() {
        return queue.remove(0);
    }

    /**
     * This method peeks the top of the queue which is the first index of the arraylist
     * @return Passenger
     */
    public Passenger peek() {
        return queue.get(0);
    }

    /**
     * This method returns a boolean to check if the arraylist is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return(queue.isEmpty());
    }

    /**
     * This method returns an arraylist of passengers
     * @return ArrayList<Passenger>
     */
    public ArrayList<Passenger> getQueue() {
        return queue;
    }

    /**
     * This method takes an arraylist<Passenger> as an argument and is used to set the queue
     * @param queue
     */
    public void setQueue(ArrayList<Passenger> queue) {
        this.queue = queue;
    }
}
