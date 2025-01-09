package objects.flight;

import objects.person.non_staff.Passenger;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private enum typeSeat {
         BUSINESS,ECONOMY
     };

    public Ticket() {}

    public Ticket(Flight flight, Passenger passenger, int typeSeat) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }



}
