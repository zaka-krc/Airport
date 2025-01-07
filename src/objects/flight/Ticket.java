package objects.flight;

import objects.person.non_staff.Passenger;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private enum typeSeat {
         BUSINESS,ECONOMY
     };

    public Ticket() {}

    public Ticket(Passenger passenger, Flight flight, String typeSeat) {
        this.passenger = new Passenger();
        this.flight = new Flight();
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
