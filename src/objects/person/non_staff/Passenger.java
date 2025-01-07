package objects.person.non_staff;
import objects.flight.Ticket;
import objects.person.Person;

public class Passenger extends Person {
    private Ticket ticket;
    private int lugageWeight;

    public Passenger() {
    }

    public Passenger(Ticket ticket, int lugageWeight) {
        this.ticket = new Ticket();
        this.lugageWeight = lugageWeight;
    }
}

