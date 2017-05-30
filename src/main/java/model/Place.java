package model;

import java.time.LocalTime;

/**
 * Created by alexandermiheev on 27.05.17.
 */
public class Place {
    private LocalTime startWorkingTime;
    private LocalTime endWorkingTime;
    private LocalTime timeWindow;

    public Place(LocalTime startWorkingTime, LocalTime endWorkingTime, LocalTime timeWindow) {
        this.startWorkingTime = startWorkingTime;
        this.endWorkingTime = endWorkingTime;
        this.timeWindow = timeWindow;
    }

    public Place(String startWorkingTime, String endWorkingTime, String timeWindow) {
        this.startWorkingTime = LocalTime.parse(startWorkingTime);
        this.endWorkingTime = LocalTime.parse(endWorkingTime);
        this.timeWindow = LocalTime.parse(timeWindow);
    }

    public LocalTime getStartWorkingTime() {
        return startWorkingTime;
    }

    public void setStartWorkingTime(LocalTime startWorkingTime) {
        this.startWorkingTime = startWorkingTime;
    }

    public LocalTime getEndWorkingTime() {
        return endWorkingTime;
    }

    public void setEndWorkingTime(LocalTime endWorkingTime) {
        this.endWorkingTime = endWorkingTime;
    }

    public LocalTime getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(LocalTime timeWindow) {
        this.timeWindow = timeWindow;
    }
}
