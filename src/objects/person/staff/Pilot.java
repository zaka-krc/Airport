package objects.person.staff;
import objects.flight.Flight;
import objects.person.Person;

public class Pilot extends Person {
    public Pilot(String name, int age, String adress, Flight flight) {
        super(name, age, adress, flight);
    }

    public Pilot() {
    }
}
