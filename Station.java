/**
 * This class creates a station object and holds all of its associated methods
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */

import java.util.Random;
import java.util.Scanner;

public class Station {
    private double ProbabilityFirst;
    private double ProbabilitySecond;
    private PassengerQueue firstClass = new PassengerQueue();
    private PassengerQueue secondClass = new PassengerQueue();
    private BooleanSource firstArrival;
    private BooleanSource secondArrival;
    private static int id = 1;
    private int arrivalTime = 0;
    private Random generator = new Random();
    private  int firstCounter =0;
    private int secondCounter = 0;

    /**
     * This method creates a station object and asks for the probabilities of peopl arriving when it is created.
     */
    public Station() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Probability Of A First Class Passenger Arriving:");
        ProbabilityFirst = input.nextDouble();
        firstArrival = new BooleanSource(ProbabilityFirst);
        System.out.println("Please Enter The Probability Of A Second Class Passenger Arriving:");
        ProbabilitySecond = input.nextDouble();
        secondArrival = new BooleanSource(ProbabilitySecond);
    }

    /**
     * This method handles id assignment and enqueueing onto the queue as well as handling the case where no one arrives. This also prints the id's of the people in the queue
     */
    public void simulateTimestep() {
        if (firstArrival.occurs()) {
            Passenger P = new Passenger(id, arrivalTime, true);
            firstClass.enqueue(P);
            System.out.println("First Class Passenger ID" + P.getId() + " arrives");
            id++;
            firstCounter++;
        } else {
            System.out.println("No First Class Passengers Arrived");
        }
        if (secondArrival.occurs()) {
            Passenger P = new Passenger(id, arrivalTime, false);
            secondClass.enqueue(P);
            System.out.println("Second Class Passenger ID" + P.getId() + " arrives");
            id++;
            secondCounter++;
        } else {
            System.out.println("No Second Class Passenger Arrived");
        }
        arrivalTime++;
        System.out.println("Queues:\nFirst:");
        for (int i = 0; i < firstClass.getQueue().size(); i++) {
            System.out.print("P" + firstClass.getQueue().get(i).getId() + "@T" + firstClass.getQueue().get(i).getArrivalTime() + " ");
        }
        System.out.println("\nSecond:");
        for (int i = 0; i < secondClass.getQueue().size(); i++) {
            System.out.print("P" + secondClass.getQueue().get(i).getId() + "@T" + secondClass.getQueue().get(i).getArrivalTime() + " ");
        }
    }

    /**
     * This method returns a passengerqueue object of the first class people
     * @return PassengerQueue
     */
    public PassengerQueue getFirstClass() {
        return firstClass;
    }

    /**
     * This method returns a BooleanSource object and gets a second class passenger
     * @return BooleanSource
     */
    public BooleanSource getSecondArrival() {
        return secondArrival;
    }

    /**
     * Thie method returns a BooleanSource object and gets a first class passenger
     * @return BooleanSource
     */
    public BooleanSource getFirstArrival() {

        return firstArrival;
    }

    /**
     * This method returns a passengerqueue which is the queue of all the second class passengers
     * @return PassengerQueue
     */
    public PassengerQueue getSecondClass() {

        return secondClass;
    }

    /**
     * This method gets a counter keeping track of how many first class passengers arrive
     * @return int
     */
    public int getFirstCounter() {
        return firstCounter;
    }

    /**
     * This method sets the first class counter
     * @param counter
     */
    public void setFirstCounter(int counter) {
        this.firstCounter = counter;
    }

    /**
     * This method returns an int value representing the amount of second class people
     * @return int
     */
    public int getSecondCounter() {
        return secondCounter;
    }

    /**
     * This method sets the second class counter
     * @param secondCounter
     */
    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }
}
