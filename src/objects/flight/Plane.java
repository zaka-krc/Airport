package objects.flight;

import objects.exceptions.DoublePerson;
import objects.exceptions.PlaneFullException;
import objects.person.Person;
import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private final int planeCapacity;
    private List<Staff> staffList = new ArrayList<>();
    private List<Passenger> passengerList = new ArrayList<>();
    private Flight flight;

    public Plane(int planeCapacity, Flight flight) {
        this.planeCapacity = planeCapacity;
        this.flight = flight;
    }

    public int getNumberPersons() {
        return passengerList.size() + staffList.size();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void addPerson(Person person) {
        boolean personExists = false;

        if (person instanceof Passenger) {
            for (Passenger p : passengerList) {
                if (p.getName().equals(person.getName())) {
                    personExists = true;
                    break;
                }
            }
            if (!personExists) {
                if (getNumberPersons() < planeCapacity) {
                    passengerList.add((Passenger) person);
                } else {
                    System.out.println("The plane is full");
                }
            } else {
                System.out.println("The person is already on the plane");
            }
        } else if (person instanceof Staff) {
            for (Staff s : staffList) {
                if (s.getName().equals(person.getName())) {
                    personExists = true;
                    break;
                }
            }
            if (!personExists) {
                if (getNumberPersons() < planeCapacity) {
                    staffList.add((Staff) person);
                } else {
                    System.out.println("The plane is full");
                }
            } else {
                System.out.println("The person is already on the plane");
            }
        }
    }
}
