package objects.person.staff;

import checks.LuggageCheck;
import objects.flight.Flight;
import objects.person.Person;
import objects.person.non_staff.Passenger;

public class LuggageAttendant extends Person implements LuggageCheck {
    private Passenger passenger;
    private Flight flight;

    public LuggageAttendant(String name, int age, String address, Flight flight, Passenger passenger) {
        super(name, age, address, flight);
        this.passenger = passenger;
        this.flight = flight;
    }

    public LuggageAttendant() {
    }

    public boolean checkLuggage() {
        return passenger.getLugageWeight() <= flight.getMaxLuggageWeight();
    }
}