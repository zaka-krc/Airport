package objects.person.staff;

import objects.flight.Flight;
import objects.flight.Plane;

public class FlightAttendant extends Staff {
    private Plane plane;
    private Flight flight;

    public FlightAttendant(String name, int age, String adress, int flightNr) {
        super(name, age, adress, flightNr);
    }

    public boolean checkPassenger(){
        return flight.getNumberOfPassengers() == plane.getNumberPersons();

    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
