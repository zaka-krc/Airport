package objects.person.staff;


import objects.flight.Flight;
import objects.person.non_staff.Passenger;

public class LuggageAttendant extends Staff  {
    private Passenger passenger;
    private Flight flight;

    public LuggageAttendant(String name, int age, String address, int flightNr) {
        super(name, age, address, flightNr);
    }

    public LuggageAttendant() {
    }

    public boolean checkLuggage() {
        return passenger.getLugageWeight() <= flight.getMaxLuggageWeight();
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