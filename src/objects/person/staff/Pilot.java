package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;

public class Pilot extends Staff {

    private FlightAttendant flightAttendant;
    private LuggageAttendant luggageAttendant;

    public Pilot(String name, int age, String address, Flight flight) {
        super(name, age, address, flight);
    }

    public String flightCheck(Flight flight, Plane plane) {
        int pilotCount = 0;
        int flightAttendantCount = 0;

        for (Staff staff : plane.getStaffList()) {
            if (staff instanceof Pilot) {
                pilotCount++;
            } else if (staff instanceof FlightAttendant) {
                flightAttendantCount++;
            }
        }

        if (pilotCount == 0) {
            return "Flight is not ready to take off: No pilots on the plane.";
        }
        if (flightAttendantCount == 0) {
            return "Flight is not ready to take off: No flight attendants on the plane.";
        }
        if (pilotCount < 2) {
            return "Flight is not ready to take off: Not enough pilots.";
        }
        if (flightAttendantCount <= 2) {
            return "Flight is not ready to take off: Not enough flight attendants.";
        }
        if (!flightAttendant.checkPassengers(plane)) {
            return "Flight is not ready to take off: Passenger count mismatch.";
        }
        if (!luggageAttendant.checkLuggage(flight, plane)) {
            return "Flight is not ready to take off: Luggage weight exceeds limit.";
        }

        return "Flight is ready to take off";
    }
}