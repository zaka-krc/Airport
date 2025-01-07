package objects.person.staff;
import objects.flight.Flight;
import objects.person.Person;

public class FlightAttendant extends Person {
    private Flight flight;
    public FlightAttendant(String name, int age, String adress, int flightNumber) {
        super(name, age, adress, flightNumber);
    }
}
