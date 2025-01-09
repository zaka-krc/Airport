package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;

public class FlightAttendant extends Staff {

    public FlightAttendant(String name, int age, String address, int flightNr) {
        super(name, age, address, flightNr);
    }

    public boolean checkPassengers(Flight flight, Plane plane) {
        return plane.getPassengerList().size() <= flight.getNumberOfPassengers();
    }
}