package objects.person.non_staff;
import objects.flight.Ticket;
import objects.person.Person;

public class Passenger extends Person {
    private Ticket ticket = new Ticket();
    private double lugageWeight;

    public Passenger(double lugageWeight) {
        this.lugageWeight = lugageWeight;
    }
    public Passenger(String passengerName, int passengerAge, String passengerAddress, double luggageWeight) {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getLugageWeight() {
        return lugageWeight;
    }

    public void setLugageWeight(int lugageWeight) {
        this.lugageWeight = lugageWeight;
    }

}

