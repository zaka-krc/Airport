package objects.flight;

import objects.person.Person;
import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;
import objects.flight.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private final int planeCapacity;
    private final double maxPlaneLuggageWeight;
    private List<Staff> staffList = new ArrayList<>();
    private List<Passenger> passengerList = new ArrayList<>();
    private Flight flight;

    public Plane(int planeCapacity, Flight flight, double maxPlaneLuggageWeight) {
        this.planeCapacity = planeCapacity;
        this.flight = flight;
        this.maxPlaneLuggageWeight = maxPlaneLuggageWeight;
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

    public double getMaxPlaneLuggageWeight() {
        return maxPlaneLuggageWeight;
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
        if (personExists(person)) {
            System.out.println("The person is already on the plane");
            return;
        }

        if (getNumberPersons() >= planeCapacity) {
            System.out.println("The plane is full");
            return;
        }

        if (person instanceof Passenger) {
            addPassenger((Passenger) person);
        } else if (person instanceof Staff) {
            staffList.add((Staff) person);
        }
    }

    private boolean personExists(Person person) {
        if (person instanceof Passenger) {
            return passengerList.stream().anyMatch(p -> p.getName().equals(person.getName()));
        } else if (person instanceof Staff) {
            return staffList.stream().anyMatch(s -> s.getName().equals(person.getName()));
        }
        return false;
    }

    private void addPassenger(Passenger passenger) {
        Ticket ticket = passenger.getTicket();
        if (ticket.getSeatChoice() == Ticket.typeSeat.BUSINESS) {
            if (flight.getBusinessSeats() > 0) {
                flight.setBusinessSeats(flight.getBusinessSeats() - 1);
                passengerList.add(passenger);
            } else {
                System.out.println("No available business seats");
            }
        } else if (ticket.getSeatChoice() == Ticket.typeSeat.ECONOMY) {
            if (flight.getEconomySeats() > 0) {
                flight.setEconomySeats(flight.getEconomySeats() - 1);
                passengerList.add(passenger);
            } else {
                System.out.println("No available economy seats");
            }
        }
    }
}