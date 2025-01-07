package objects.flight;

import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private int numberPersons;
    private int economySeats;
    private int businessSeats;
    private List<Staff> staffList = new ArrayList<>();;
    private List<Passenger> passengerList = new ArrayList<>();;


    private Flight flight;

    public Plane() {
        this.numberPersons = 0;
        this.economySeats = 0;
        this.businessSeats = 0;
    }

    public void setNumberPersons(int numberPersons) {
        this.numberPersons = numberPersons;
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

    public Plane(int numberPersons, int economySeats, int businessSeats) {
        this.numberPersons = numberPersons;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
    }

    public int getNumberPersons() {
        return numberPersons;
    }


}



