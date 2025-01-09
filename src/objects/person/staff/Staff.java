package objects.person.staff;

import objects.flight.Flight;
import objects.person.Person;

public abstract class Staff extends Person {
    private Flight flight;

    public Staff(String name, int age, String adress, int flightNr) {
        super(name, age, adress, flightNr);
    }

    public Staff() {
    }
}
