package objects.flight;

import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private int numberPersons;
    private int economySeats;
    private int businessSeats;
    private double luggageWeight;
    private List<Staff> staffList = new ArrayList<>();;
    private List<Passenger> passengerList = new ArrayList<>();;


    private Flight flight;

    public Plane() {
        this.numberPersons = 0;
        this.economySeats = 0;
        this.businessSeats = 0;
    }


    public Plane(int economySeats, int businessSeats, double luggageWeight, List<Staff> staffList, List<Passenger> passengerList, Flight flight) {
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.luggageWeight = luggageWeight;
        this.staffList = staffList;
        this.passengerList = passengerList;
        this.flight = flight;
    }



    public void getNumberPersons(int numberPersons) {
        numberPersons = passengerList.size() + staffList.size();
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNumberPersons() {
        return numberPersons;
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


}



