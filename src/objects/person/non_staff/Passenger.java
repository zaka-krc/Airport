package objects.person.non_staff;

import objects.flight.Flight;
import objects.flight.Ticket;
import objects.person.Person;

public class Passenger extends Person {
    private Ticket ticket;
    private double luggageWeight;

    public Passenger(String name, int age, String address, Flight flight, double luggageWeight, Ticket ticket) {
        super(name, age, address, flight);
        this.luggageWeight = luggageWeight;
        this.ticket = ticket;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}