package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;
import objects.person.non_staff.Passenger;

public class LuggageAttendant extends Staff {
    private Flight flight;

    public LuggageAttendant(String name, int age, String address, int flightNr) {
        super(name, age, address, flightNr);
    }

    public boolean checkLuggage(Flight flight, Plane plane) {
        for (Passenger p : plane.getPassengerList()) {
            if (p.getLuggageWeight() > flight.getMaxLuggageWeight()) {
                return false;
            }
        }
        return true;
    }
}