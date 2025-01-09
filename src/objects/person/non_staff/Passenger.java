package objects.person.non_staff;
import objects.flight.Flight;
import objects.person.Person;

public class Passenger extends Person {
    private double lugageWeight;


    public Passenger(String name, int age, String adress, int flightNr, double lugageWeight) {
        super(name, age, adress, flightNr);
        this.lugageWeight = lugageWeight;
    }

    public double getLugageWeight() {
        return lugageWeight;
    }

    public void setLugageWeight(int lugageWeight) {
        this.lugageWeight = lugageWeight;
    }

}

