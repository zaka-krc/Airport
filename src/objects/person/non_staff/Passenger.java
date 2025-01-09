package objects.person.non_staff;
import objects.flight.Flight;
import objects.flight.Ticket;
import objects.person.Person;

public class Passenger extends Person {
    private Ticket ticket = new Ticket();
    private double lugageWeight;


    public Passenger(String name, int age, String adress, int flightNr, double lugageWeight) {
        super(name, age, adress, flightNr);
        this.lugageWeight = lugageWeight;
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

