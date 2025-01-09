package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;

public class Pilot extends Staff {

    public Pilot(String name, int age, String address, Flight flight, StaffType staffType) {
        super(name, age, address, flight, staffType);
    }

}