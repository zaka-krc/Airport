package objects.person.non_staff;
import objects.person.Person;

public class Passenger extends Person {
    private String typeSeat;
    private int luggages;

    public Passenger(String name, int age, String adress, int flightNumber, String typeSeat, int luggages) {
        super(name, age, adress, flightNumber);
        this.typeSeat = typeSeat;
        this.luggages = luggages;
    }
}
