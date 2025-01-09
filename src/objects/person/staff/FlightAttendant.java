package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;
import objects.flight.Ticket;
import objects.person.non_staff.Passenger;

public class FlightAttendant extends Staff {

    public FlightAttendant(String name, int age, String address, Flight flight) {
        super(name, age, address, flight);
    }

    public boolean checkPassengers(Plane plane) {
        return plane.getPassengerList().size() <= plane.getPlaneCapacity();


    }

}