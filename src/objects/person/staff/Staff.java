package objects.person.staff;

import objects.person.Person;

public abstract class Staff extends Person {
    public Staff(String name, int age, String adress, int flightNumber) {
        super(name, age, adress, flightNumber);
    }

    public Staff() {
    }
}
