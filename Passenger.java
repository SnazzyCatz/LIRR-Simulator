/**
 * This class makes a passenger object which will be put into an arraylist in passenger queue
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */
public class Passenger {
    public int id;
    public int arrivalTime;
    public boolean isFirstClass;

    /**
     *This creates a passenger object and it's given an id, arrivaltime and first class status
     * @param id
     * @param arrivalTime
     * @param isFirstClass
     */
    public Passenger(int id, int arrivalTime, boolean isFirstClass) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.isFirstClass = isFirstClass;
    }

    /**
     * This is a default passenger object with default values
     */
    public Passenger() {
        id = -1;
        arrivalTime = -1;
        isFirstClass = false;
    }

    /**
     * This method returns the arrivaltime of the passenger in integer form
     * @return int
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * This method takes an integer input and sets the arrivaltime of the passenger
     * @param arrivalTime
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * This method checks if a passenger is first class
     * @return boolean
     */
    public boolean isFirstClass() {

        return isFirstClass;
    }

    /**
     * This method allows you to set a passenger to first class or not first class
     * @param firstClass
     */
    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    /**
     * This method gets the id of a passenger in the for of an int
     * @return int
     */
    public int getId() {

        return id;
    }

    /**
     * This method takes an integer argument and sets it to the passengers id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}