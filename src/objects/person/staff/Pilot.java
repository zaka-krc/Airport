package objects.person.staff;

public class Pilot extends Staff {
    public Pilot(String name, int age, String adress, int flightNr) {
        super(name, age, adress, flightNr);
    }

package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;
import java.util.List;

    public class Pilot extends Staff {
        private FlightAttendant flightAttendant;
        private LuggageAttendant luggageAttendant;

        public Pilot(String name, int age, String address, int flightNr, FlightAttendant flightAttendant, LuggageAttendant luggageAttendant, List<Staff> staffList) {
            super(name, age, address, flightNr);

        }

        public String flightCheck(Flight flight, Plane plane) {
            int pilotCount = 0;
            int flightAttendantCount = 0;

            for (Staff staff : staffList) {
                if (staff instanceof Pilot) {
                    pilotCount++;
                } else if (staff instanceof FlightAttendant) {
                    flightAttendantCount++;
                }
            }

            if (pilotCount < 2) {
                return "Flight is not ready to take off: Not enough pilots.";
            }
            if (flightAttendantCount <= pilotCount) {
                return "Flight is not ready to take off: Not enough flight attendants.";
            }
            if (!flightAttendant.checkPassengers(flight, plane)) {
                return "Flight is not ready to take off: Passenger count mismatch.";
            }
            if (!luggageAttendant.checkLuggage(flight, plane)) {
                return "Flight is not ready to take off: Luggage weight exceeds limit.";
            }
            return "Flight is ready to take off";
        }
    }

}
