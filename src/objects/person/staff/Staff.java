package objects.person.staff;

import objects.flight.Flight;
import objects.person.Person;

public abstract class Staff extends Person {
    private StaffType staffType;
    public enum StaffType {
        FLIGHT_ATTENDANT,
        LUGGAGE_ATTENDANT,
        PILOT
    }

    public Staff(String name, int age, String address, Flight flight, StaffType staffType) {
        super(name, age, address, flight);
        this.staffType = staffType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "staffType=" + staffType +
                '}';
    }
}
