package objects.person.staff;

import objects.flight.Flight;
import objects.person.Person;

public abstract class Staff extends Person {

    public Staff(String name, int age, String adress, Flight flight) {
        super(name, age, adress, flight);
    }

    public Staff() {
    }
}
