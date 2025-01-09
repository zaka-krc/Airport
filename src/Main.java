import objects.flight.Flight;
import objects.flight.Plane;
import objects.flight.Ticket;
import objects.person.non_staff.Passenger;
import objects.person.staff.FlightAttendant;
import objects.person.staff.LuggageAttendant;
import objects.person.staff.Pilot;
import objects.person.staff.Staff;

import java.util.Scanner;

public class Main {
    private static Flight flight;
    private static Plane plane;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            if (flight == null || plane == null) {
                System.out.println("Please create a flight and plane first.");
                createFlightAndPlane();
            }
        } while (flight == null || plane == null);

        while (true) {
            System.out.println("1. Create new Flight and Plane");
            System.out.println("2. Add Passenger");
            System.out.println("3. Add Staff");
            System.out.println("4. Perform Flight Check");
            System.out.println("5. Print Flight Info");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createFlightAndPlane();
                    break;
                case 2:
                    addPassenger();
                    break;
                case 3:
                    addStaff();
                    break;
                case 4:
                    performFlightCheck();
                    break;
                case 5:
                    printFlightInfo();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createFlightAndPlane() {
        System.out.println("Enter flight number: ");
        int flightNumber = getIntInput();
        scanner.nextLine();
        System.out.println("Enter departure location: ");
        String startDestination = scanner.nextLine();
        System.out.println("Enter destination: ");
        String endDestination = scanner.nextLine();
        System.out.println("Enter max luggage weight: ");
        double maxLuggageWeight = getDoubleInput();
        System.out.println("Enter number of economy seats: ");
        int economySeats = getIntInput();
        System.out.println("Enter number of business seats: ");
        int businessSeats = getIntInput();
        System.out.println("Enter plane capacity: ");
        int planeCapacity = getIntInput();
        System.out.println("Enter max plane weight capacity: ");
        int maxPlaneLuggageWeight = getIntInput();

        flight = new Flight(flightNumber, startDestination, endDestination, economySeats, businessSeats, maxLuggageWeight);
        plane = new Plane(planeCapacity, flight, maxPlaneLuggageWeight);
        System.out.println("Flight and Plane created successfully.");
    }

    private static void addPassenger() {
        System.out.println("Enter passenger name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter passenger age: ");
        int age = getIntInput();
        scanner.nextLine();
        System.out.println("Enter passenger address: ");
        String address = scanner.nextLine();
        System.out.println("Enter flight number: ");
        int flightNr = getIntInput();
        if (flightNr != flight.getFlightNumber()) {
            System.out.println("Invalid flight number. Passenger not added.");
            return;
        }
        System.out.println("Enter luggage weight: ");
        int luggageWeight = getIntInput();
        scanner.nextLine();
        System.out.println("Enter seat type: 1. Business 2. Economy ");
        int seatChoice = getIntInput();

        Passenger passenger = new Passenger(name, age, address, flight, luggageWeight);
        Ticket ticket = new Ticket(flight, passenger, seatChoice);
        passenger.setLuggageWeight(luggageWeight);
        plane.addPerson(passenger);
        System.out.println("Passenger added successfully.");
    }

    private static void addStaff() {
        System.out.println("Enter staff type: 1.Flight Attendant 2. Attendant 3. Pilot ");
        int staffTypeChoice = getIntInput();
        String staffType;
        switch (staffTypeChoice) {
            case 1:
                staffType = "FlightAttendant";
                break;
            case 2:
                staffType = "LuggageAttendant";
                break;
            case 3:
                staffType = "Pilot";
                break;
            default:
                System.out.println("Invalid staff type. Staff not added.");
                return;
        }

        System.out.println("Enter staff name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter staff age: ");
        int age = getIntInput();
        scanner.nextLine();
        System.out.println("Enter staff address: ");
        String address = scanner.nextLine();
        System.out.println("Enter flight number: ");
        int flightNr = getIntInput();
        if (flightNr != flight.getFlightNumber()) {
            System.out.println("Invalid flight number. Staff not added.");
            return;
        }
        scanner.nextLine();

        Staff staff = null;
        switch (staffType) {
            case "FlightAttendant":
                staff = new FlightAttendant(name, age, address, flight);
                break;
            case "LuggageAttendant":
                staff = new LuggageAttendant(name, age, address, flight);
                break;
            case "Pilot":
                staff = new Pilot(name, age, address, flight);
                break;
            default:
                System.out.println("Invalid staff type");
        }
        plane.addPerson(staff);
        System.out.println(staffType + " added successfully.");
    }

    private static void performFlightCheck() {
        Pilot pilot = null;
        for (Staff staff : plane.getStaffList()) {
            if (staff instanceof Pilot) {
                pilot = (Pilot) staff;
                break;
            }
        }
        if (pilot == null) {
            System.out.println("No pilot found on the plane.");
            return;
        }
        String result = pilot.flightCheck(flight, plane);
        System.out.println("Flight check result: " + result);
    }

    private static void printFlightInfo() {
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Departure: " + flight.getStartDestination());
        System.out.println("Destination: " + flight.getEndDestination());
        System.out.println("Number of Passengers: " + plane.getPassengerList().size());
        System.out.println("Max Luggage Weight: " + flight.getMaxLuggageWeight());
        System.out.println("Number of Economy Seats: " + flight.getEconomySeats());
        System.out.println("Number of Business Seats: " + flight.getBusinessSeats());
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}