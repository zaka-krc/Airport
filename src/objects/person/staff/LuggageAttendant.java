package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;
import objects.person.non_staff.Passenger;

public class LuggageAttendant extends Staff {

    public LuggageAttendant(String name, int age, String address, Flight flight, StaffType staffType) {
        super(name, age, address, flight, staffType);
    }
}

