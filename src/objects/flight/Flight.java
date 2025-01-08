package objects.flight;

import objects.person.non_staff.Passenger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private int numberOfPassengers;
    private String endDestination;
    private String startDestination;
    private Plane plane;
    private double maxLuggageWeight;
    private List<Passenger> passengers;

    public Flight(String flightNumber, double maxLuggageWeight) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            throw new IllegalArgumentException("Flight number must not be empty.");
        }
        if (maxLuggageWeight <= 0) {
            throw new IllegalArgumentException("Max luggage weight must be positive.");
        }
        this.flightNumber = flightNumber;
        this.maxLuggageWeight = maxLuggageWeight;
        this.passengers = new ArrayList<>();
    }

    public Flight(String flightNumber, int numberOfPassengers, String endDestination, String startDestination, Plane plane, double maxLuggageWeight) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            throw new IllegalArgumentException("Flight number must not be empty.");
        }
        if (maxLuggageWeight <= 0) {
            throw new IllegalArgumentException("Max luggage weight must be positive.");
        }
        this.flightNumber = flightNumber;
        this.numberOfPassengers = numberOfPassengers;
        this.endDestination = endDestination;
        this.startDestination = startDestination;
        this.plane = plane;
        this.maxLuggageWeight = maxLuggageWeight;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            throw new IllegalArgumentException("Flight number must not be empty.");
        }
        this.flightNumber = flightNumber;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(String endDestination) {
        this.endDestination = endDestination;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getMaxLuggageWeight() {
        return maxLuggageWeight;
    }

    public void setMaxLuggageWeight(double maxLuggageWeight) {
        if (maxLuggageWeight <= 0) {
            throw new IllegalArgumentException("Max luggage weight must be positive.");
        }
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void savePassengerListToFile() {
        try (FileWriter writer = new FileWriter(flightNumber + "_passengers.txt")) {
            for (Passenger passenger : passengers) {
                writer.write(passenger.toString() + "\n");
            }
            System.out.println("Passenger list saved to file: " + flightNumber + "_passengers.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}