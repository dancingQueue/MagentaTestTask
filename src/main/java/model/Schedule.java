package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 27.05.17.
 */
public class Schedule {

    private int startTimes[];
    private int endTimes[];
    private int durationTimes[];
    private int travelTimes[];
    private int departmentStartTime;
    private int departmentEndTime;
    private int amountOfPlaces;
    private int calculatedOptimalStartTime;
    private int calculatedOptimalEndTime;

    private List<LocalTime> arrivingTimes;
    private List<LocalTime> departingTimes;

    public LocalTime getOptimalStartTime() {
        return LocalTime.ofSecondOfDay(calculatedOptimalStartTime);
    }

    public LocalTime getOpticalEndTime() {
        return LocalTime.ofSecondOfDay(calculatedOptimalEndTime);
    }

    public List<LocalTime> getArrivingTimes() {
        return arrivingTimes;
    }

    public List<LocalTime> getDepartingTimes() {
        return departingTimes;
    }

    public Schedule(Task task) {
        departmentStartTime = task.getDepartmentStartTime().toSecondOfDay();
        departmentEndTime = task.getDepartmentEndTime().toSecondOfDay();

        Constraint currentConstraint = task.getConstraint();

        amountOfPlaces = currentConstraint.getAmountOfPlaces();

        startTimes = new int[amountOfPlaces];
        endTimes = new int[amountOfPlaces];

        durationTimes = new int[amountOfPlaces];
        travelTimes = new int[amountOfPlaces + 1];

        List<Place> places = currentConstraint.getPlacesToVisit();
        List<LocalTime> currentTravelTimes = currentConstraint.getTravelTimes();

        for (int i = 0; i < amountOfPlaces; i++) {
            Place currentPlace = places.get(i);
            startTimes[i] = currentPlace.getStartWorkingTime().toSecondOfDay();
            endTimes[i] = currentPlace.getEndWorkingTime().toSecondOfDay();
            durationTimes[i] = currentPlace.getTimeWindow().toSecondOfDay();
        }

        for (int i = 0; i < amountOfPlaces + 1; i++) {
            travelTimes[i] = currentTravelTimes.get(i).toSecondOfDay();
        }

        computeSchedule();
    }

    private boolean isCurrentSolutionFeasible(int startTime) {
        int currentTime = startTime;
        for (int i = 0; i < amountOfPlaces; i++) {
            currentTime += travelTimes[i];
            if (currentTime < startTimes[i]) {
                currentTime = startTimes[i];
            }
            if (currentTime + durationTimes[i] <= endTimes[i]) {
                currentTime += durationTimes[i];
            } else {
                return false;
            }
        }

        if (currentTime + travelTimes[amountOfPlaces] > departmentEndTime) {
            return false;
        }

        return true;
    }
    // Using binary search to get the optimal starting time
    private void computeOptimalStartTime() {
        int minValue = departmentStartTime;
        int maxValue = departmentEndTime;

        while (minValue < maxValue - 1) {
            int currentStartTime = (minValue + maxValue) / 2;
            boolean isFeasible = isCurrentSolutionFeasible(currentStartTime);
            if (isFeasible) {
                minValue = currentStartTime;
            } else {
                maxValue = currentStartTime - 1;
            }
        }
        calculatedOptimalStartTime = (maxValue + minValue) / 2;

    }

    public void printSchedule() {
        System.out.println("Start from the department at " + getOptimalStartTime());

        for (int i = 0; i < amountOfPlaces; i++) {
            System.out.println("Get to the " + (i + 1) + " place at " + arrivingTimes.get(i));
            System.out.println("Finish the shipment and get off to the next task at " + departingTimes.get(i));
        }

        System.out.println("Get back to the department at " + getOpticalEndTime());

    }



    private void computeSchedule() {
        computeOptimalStartTime();

        int currentTime = calculatedOptimalStartTime;
        arrivingTimes = new ArrayList<>();
        departingTimes = new ArrayList<>();

        for (int i = 0; i < amountOfPlaces; i++) {
            currentTime += travelTimes[i];
            arrivingTimes.add(LocalTime.ofSecondOfDay(currentTime));
            if (currentTime < startTimes[i]) {
                currentTime = startTimes[i];
            }
            currentTime += durationTimes[i];
            departingTimes.add(LocalTime.ofSecondOfDay(currentTime));
        }
        currentTime += travelTimes[amountOfPlaces];
        calculatedOptimalEndTime = currentTime;

    }
}
