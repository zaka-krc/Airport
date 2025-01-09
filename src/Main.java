import objects.flight.Flight;
import objects.flight.Plane;
import objects.person.non_staff.Passenger;

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight(1, 0, "Copenhagen", "Berlin", 100, 50, 10);
        Passenger passenger = new Passenger("John", 30, "Copenhagen", 1, 20);
        Plane plane = new Plane(3, flight);
        plane.addPerson(passenger);
        Passenger passenger1 = new Passenger("John", 30, "Copenhagen", 1, 20);
        plane.addPerson(passenger1);

        Passenger passenger2 = new Passenger("Johny", 30, "Copenhagen", 1, 20);
        plane.addPerson(passenger2);



    }
}