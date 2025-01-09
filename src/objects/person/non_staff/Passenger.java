package objects.person.non_staff;

import objects.person.Person;

public class Passenger extends Person {
    private double luggageWeight;

    public Passenger(String name, int age, String address, int flightNr, double luggageWeight) {
        super(name, age, address, flightNr);
        this.luggageWeight = luggageWeight;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }
}