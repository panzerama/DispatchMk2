package db;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

import models.Event;

public class MockDataGenerator {
    private static final String[] STREETS = new String[]{
            "Seneca", "Spring", "University", "Union", "Cherry", "Columbia", "Pike", "Pine"
    };

    private static final String[] CITY = new String[]{
            "Burien", "Tacoma", "Redmond", "Everett", "Seattle", "Bothell", "Bellvue", "Renton"
    };
    private Calendar thisCalendar = new GregorianCalendar();
    private Date thisDate = thisCalendar.getTime();

    public Event generateSimpleEvent(){
        String newEventDate = thisDate.toString();
        String newEventAddress = generateSimpleStreetAddress();
        return new Event(newEventAddress, newEventDate);
    }

    private String generateSimpleStreetAddress(){
        int houseNumber = ThreadLocalRandom.current().nextInt(1, 200);
        String street = STREETS[ThreadLocalRandom.current().nextInt(0,6)];
        String city = CITY[ThreadLocalRandom.current().nextInt(0,7)];
        int zipCode = ThreadLocalRandom.current().nextInt(10000, 99999);

        return Integer.toString(houseNumber) + " " + street + " " + city + " WA " + Integer.toString(zipCode);
    }
}
