/**
 * This class creates train objects
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */

import java.util.ArrayList;

public class Train {
    private int firstCapacity;
    private int secondCapacity;
    private int timeUntilNextArrival;
    private static int firstClassTracker = 0;
    private static int secondClassTracker = 0;
    private static int firstClassOverflow = 0;
    private static int secondClassOverflow = 0;
    private int trainNumber;
    private ArrayList<Station> Train = new ArrayList<Station>();

    /**
     * This method creates a default train object
     */
    public Train() {

    }

    /**
     * This method returns a tracker that keeps track of how many first class people are in the train
     * @return int
     */
    public int getFirstClassTracker() {
        return firstClassTracker;
    }

    /**
     * This method gets the amount of excess people who couldnt fit on the train in first class
     * @return int
     */
    public int getFirstClassOverflow() {

        return firstClassOverflow;
    }

    /**
     * This method returns a trainnumber and takes an int that will be assigned to the trains number
     * @param trainNumber
     */
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    /**
     * This method returns an int representing the train number
     * @return int
     */
    public int getTrainNumber() {
        return trainNumber;
    }

    /**
     * This method  returns an int value representing how many people are on the train
     * @return int
     */
    public int getSecondClassTracker() {
        return secondClassTracker;
    }

    /**
     * This method handles the dequeueing of the stations and takes a station parameter. It also checks if the station is empty
     * @param station
     */
    public void simulateTimeStep(Station station) {
        if (!station.getFirstClass().isEmpty()) {
            for (int i = 0; i < station.getFirstClass().getQueue().size(); i++) {
                if (firstClassTracker >= firstCapacity) {
                    firstClassOverflow++;
                }
                if (firstClassTracker < firstCapacity) {
                    firstClassTracker++;
                    System.out.println("\nPassengers Embarking in First Class: ID" + station.getFirstClass().getQueue().get(i).getId());
                    station.getFirstClass().dequeue();
                }
            }
        }
        if (!station.getSecondClass().isEmpty()) {
            for (int i = 0; i < station.getSecondClass().getQueue().size(); i++) {
                if (secondClassTracker >= secondCapacity) {
                    secondClassOverflow++;
                }
                if (secondClassTracker < secondCapacity) {
                    secondClassTracker++;
                    System.out.println("\nPassengers Embarking in Second Class: ID" + station.getSecondClass().getQueue().get(i).getId());
                    station.getSecondClass().dequeue();
                }
            }
        }
    }

    /**
     * This method gets the capacity of the first class space on the train
     * @return int
     */
    public int getFirstCapacity() {
        return firstCapacity;
    }

    /**
     * This method sets the capacity of the first class space on train
     * @param firstCapacity
     */
    public void setFirstCapacity(int firstCapacity) {
        this.firstCapacity = firstCapacity;
    }

    /**
     * This method gets the capacity of the second class space on the train
     * @return int
     */
    public int getSecondCapacity() {
        return secondCapacity;
    }

    /**
     * This method sets the second class space
     * @param secondCapacity
     */
    public void setSecondCapacity(int secondCapacity) {
        this.secondCapacity = secondCapacity;
    }

    /**
     * This method returns an int value representing how long until the train arrives
     * @return int
     */
    public int getTimeUntilNextArrival() {
        return timeUntilNextArrival;
    }

    /**
     * This method sets the arrival time of the train and takes an int parameter to do so
     * @param timeUntilNextArrival
     */
    public void setTimeUntilNextArrival(int timeUntilNextArrival) {
        this.timeUntilNextArrival = timeUntilNextArrival;
    }

    /**
     * this method returns a listof stations
     * @return ArrayList<Station>
     */
    public ArrayList<Station> getTrain() {
        return Train;
    }

    /**
     * This method sets the arraylist to something and takes an arraylist as a parameter
     * @param train
     */
    public void setTrain(ArrayList<Station> train) {
        Train = train;
    }
}
