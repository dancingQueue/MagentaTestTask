import model.Task;
import model.Constraint;
import model.Place;
import model.Schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 27.05.17.
 */
public class Run {

    public void sampleTestOne() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "11:00:00", "00:10:00"));
        places.add(new Place("11:00:00", "11:30:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));

        Constraint constraint = new Constraint(2, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void sampleTestTwo() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "11:00:00", "00:10:00"));
        places.add(new Place("11:00:00", "11:20:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));

        Constraint constraint = new Constraint(2, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void testWithOnlyOnePossibleStartTime() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "10:10:00", "00:10:00"));
        places.add(new Place("11:00:00", "11:20:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));

        Constraint constraint = new Constraint(2, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void sampleTestThree() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "11:00:00", "00:10:00"));
        places.add(new Place("11:30:00", "12:00:00", "00:20:00"));
        places.add(new Place("13:00:00", "14:20:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));

        Constraint constraint = new Constraint(3, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void testWhenAllThePlacesWorkAllDay() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("00:00:00", "23:59:59", "00:10:00"));
        places.add(new Place("00:00:00", "23:59:59", "00:20:00"));
        places.add(new Place("00:00:00", "23:59:59", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("01:00:00"));

        Constraint constraint = new Constraint(3, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void sampleTestFour() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "11:00:00", "00:10:00"));
        places.add(new Place("12:00:00", "13:00:00", "00:20:00"));
        places.add(new Place("14:00:00", "15:00:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));

        Constraint constraint = new Constraint(3, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }

    public void sampleTestFive() {

        List<Place> places = new ArrayList<>();
        places.add(new Place("10:00:00", "11:00:00", "00:10:00"));
        places.add(new Place("11:00:00", "11:30:00", "00:20:00"));
        places.add(new Place("12:30:00", "13:00:00", "00:20:00"));

        List<LocalTime> travelTimes = new ArrayList<>();

        travelTimes.add(LocalTime.parse("01:00:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));
        travelTimes.add(LocalTime.parse("00:30:00"));

        Constraint constraint = new Constraint(3, places, travelTimes);

        Task task = new Task("09:00:00", "22:00:00", constraint);

        Schedule sc = new Schedule(task);
        sc.printSchedule();

        System.out.println("***");
    }



    public void run() {
        sampleTestOne();
        sampleTestTwo();
        testWithOnlyOnePossibleStartTime();
        sampleTestThree();
        testWhenAllThePlacesWorkAllDay();
        sampleTestFour();
        sampleTestFive();
    }
}
