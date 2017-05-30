package model;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by alexandermiheev on 27.05.17.
 */

// Amount of places - number of places, that should be visited
// Places to visit - list of places with working hours and dumping time
// Travel times - list of travel times from the department to the first place, ..., from the last place back to the department

public class Constraint {
    private Integer amountOfPlaces;
    private List<Place> placesToVisit;
    private List<LocalTime> travelTimes;


    public Constraint(Integer amountOfPlaces, List<Place> placesToVisit, List<LocalTime> travelTimes) {
        this.amountOfPlaces = amountOfPlaces;
        this.placesToVisit = placesToVisit;
        this.travelTimes = travelTimes;
    }

    public Integer getAmountOfPlaces() {
        return amountOfPlaces;
    }

    public void setAmountOfPlaces(Integer amountOfPlaces) {
        this.amountOfPlaces = amountOfPlaces;
    }

    public List<Place> getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(List<Place> placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public List<LocalTime> getTravelTimes() {
        return travelTimes;
    }

    public void setTravelTimes(List<LocalTime> travelTimes) {
        this.travelTimes = travelTimes;
    }
}
