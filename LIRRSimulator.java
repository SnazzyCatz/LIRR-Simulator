/**
 * This is the main method which uses all of the other classes and their methods
 *
 * @author Michael Fasano
 * michael.fasano@stonybrook.edu
 * 110798138
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LIRRSimulator {
    public static int time;
    public static int trains;
    public static int pass = 0;
    public static int tracks = 0;
    public static int firstOver = 0;
    public static int secondOver = 0;
    public static boolean go = true;

    public static void main(String args[]) {
        while(go) {
            try {
                System.out.println("Mineola:");
                Station Mineola = new Station();
                System.out.println("Hicksville:");
                Station Hicksville = new Station();
                System.out.println("Syosset:");
                Station Syosset = new Station();
                System.out.println("Huntington:");
                Station Huntington = new Station();
                System.out.println("Enter Train Capacities");
                Scanner input = new Scanner(System.in);
                System.out.println("Please Enter The First Class Capacity");
                final int firstcap = input.nextInt();
                System.out.println("Please Enter The Second Class Capacity");
                final int secondcap = input.nextInt();
                ArrayList<Station> stops = new ArrayList<Station>();
                ArrayList<Train> allTrains = new ArrayList<Train>();
                stops.add(Huntington);
                stops.add(Syosset);
                stops.add(Hicksville);
                stops.add(Mineola);

                System.out.println("Please Enter The Number Of Trains Running");
                trains = input.nextInt();
                System.out.println("Please Enter Last Arrival Time Of Passengers");
                time = input.nextInt();
                int x = 0;
                int times = 0;
                for (int i = 0; i <= trains; i++) {
                    Train trains = new Train();
                    trains.setFirstCapacity(firstcap * 4);
                    trains.setSecondCapacity(secondcap * 4);
                    trains.setTrain(stops);
                    trains.setTimeUntilNextArrival(times);
                    trains.setTrainNumber(i);
                    allTrains.add(i, trains);
                    times -= 5;
                }
                while (x < time) {
                    System.out.println("\nTimeCount:" + pass);
                    System.out.println();
                    System.out.println("Mineola");
                    Mineola.simulateTimestep();
                    System.out.println("\n\nSyosset");
                    Syosset.simulateTimestep();
                    System.out.println("\n\nHuntington");
                    Huntington.simulateTimestep();
                    System.out.println("\n\nHicksville");
                    Hicksville.simulateTimestep();

                    pass++;
                    for (int i = 0; i < allTrains.size(); i++) {
                        if (allTrains.get(i).getFirstClassTracker() < firstcap || allTrains.get(i).getSecondClassTracker() < secondcap) {
                            allTrains.get(i).simulateTimeStep(stops.get(i % 4));

                        } else if (allTrains.get(i).getFirstClassTracker() >= firstcap) {
                            firstOver++;
                        }
                        if (allTrains.get(i).getSecondClassTracker() >= secondcap) {
                            secondOver++;
                        } else {

                        }
                        tracks = allTrains.get(i).getFirstClassTracker();
                        tracks = allTrains.get(i).getSecondClassTracker();
                    }
                    for (int i = 0; i < allTrains.size(); i++) {
                        if (allTrains.get(i).getTimeUntilNextArrival() == 0) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Has Arrived In Huntington");
                        }
                        if (allTrains.get(i).getTimeUntilNextArrival() == 5) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Has Arrived In Syosset");
                        }
                        if (allTrains.get(i).getTimeUntilNextArrival() == 10) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Has Arrived In Hicksville");
                        }
                        if (allTrains.get(i).getTimeUntilNextArrival() == 15) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Has Arrived In Mineola");
                        }
                        if (allTrains.get(i).getTimeUntilNextArrival() > 15) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Has Completed Its Route");
                        }
                        if (allTrains.get(i).getTimeUntilNextArrival() < 0) {
                            System.out.println("Train #" + allTrains.get(i).getTrainNumber() + " Will Arrive At Huntington In " + allTrains.get(i).getTimeUntilNextArrival() * -1);
                        }
                        allTrains.get(i).setTimeUntilNextArrival(allTrains.get(i).getTimeUntilNextArrival() + 5);
                    }
                    x++;
                }
                System.out.println("A Total Of:" + (secondOver + firstOver + tracks) + " Were Served." + firstOver + " First Class Passengers Were Left Without A Seat Or Arrived After The Last Train Time And " +
                        secondOver + " Second Class Passengers Were Left Without A Seat Or Arrivated After The Last Train Time.");
                System.out.println(Mineola.getFirstCounter() + " First Class Passengers Were Served In Mineola " + Mineola.getSecondCounter() + " Second Class Passengers Were Served In Mineola");
                System.out.println(Hicksville.getFirstCounter() + " First Class Passengers Were Served In Hicksville And " + Hicksville.getSecondCounter() + " Second Class Passengers Were Served In Hicksville");
                System.out.println(Syosset.getFirstCounter() + " First Class Passengers Were Served In Syosset And " + Syosset.getSecondCounter() + " Second Class Passengers Were Served In Syosset");
                System.out.println(Huntington.getFirstCounter() + " Firt Class Passengers Were Served In Huntington And " + Huntington.getSecondCounter() + " Second Class Passengers Were Served In Huntington");
                go = false;

            } catch (Exception e) {
                System.out.println("AN ERROR HAS OCCURRED PLEASE REINPUT ALL YOU'RE INPUTS");
            }
        }
    }
}
