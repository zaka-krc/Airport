import objects.flight.Flight;
import objects.person.non_staff.Passenger;
import objects.person.staff.LuggageAttendant;
import objects.person.staff.Pilot;
import objects.person.staff.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Flight currentFlight = null;

        while (true) {
            System.out.println("Select an option to create an instance:");
            System.out.println("1. Flight");
            System.out.println("2. Passenger");
            System.out.println("3. LuggageAttendant");
            System.out.println("4. Pilot");
            System.out.println("5. Staff");
            System.out.println("6. Print Flight Info and Save Passenger List");
            System.out.println("7. Exit");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter flight details:");
                    System.out.print("Flight number: ");
                    String flightNumber = userInput.nextLine();
                    System.out.print("Max luggage weight: ");
                    double maxLuggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    currentFlight = new Flight(flightNumber, maxLuggageWeight);
                    System.out.println("Flight created: " + currentFlight);
                    break;
                case 2:
                    if (currentFlight == null) {
                        System.out.println("Please create a flight first.");
                        break;
                    }
                    System.out.println("Enter passenger details:");
                    System.out.print("Name: ");
                    String passengerName = userInput.nextLine();
                    System.out.print("Age: ");
                    int passengerAge = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Address: ");
                    String passengerAddress = userInput.nextLine();
                    System.out.print("Luggage weight: ");
                    double luggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    Passenger passenger = new Passenger(passengerName, passengerAge, passengerAddress, luggageWeight);
                    currentFlight.addPassenger(passenger);
                    System.out.println("Passenger created: " + passenger);
                    break;
                case 3:
                    System.out.println("Enter luggage attendant details:");
                    System.out.print("Name: ");
                    String attendantName = userInput.nextLine();
                    System.out.print("Age: ");
                    int attendantAge = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Address: ");
                    String attendantAddress = userInput.nextLine();
                    System.out.print("Flight number: ");
                    String attendantFlightNumber = userInput.nextLine();
                    System.out.print("Max luggage weight: ");
                    double attendantMaxLuggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    Flight attendantFlight = new Flight(attendantFlightNumber, attendantMaxLuggageWeight);
                    System.out.print("Passenger name: ");
                    String attendantPassengerName = userInput.nextLine();
                    System.out.print("Passenger age: ");
                    int attendantPassengerAge = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Passenger address: ");
                    String attendantPassengerAddress = userInput.nextLine();
                    System.out.print("Passenger luggage weight: ");
                    double attendantPassengerLuggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    Passenger attendantPassenger = new Passenger(attendantPassengerName, attendantPassengerAge, attendantPassengerAddress, attendantPassengerLuggageWeight);
                    LuggageAttendant luggageAttendant = new LuggageAttendant(attendantName, attendantAge, attendantAddress, attendantFlight, attendantPassenger);
                    System.out.println("Luggage Attendant created: " + luggageAttendant);
                    break;
                case 4:
                    System.out.println("Enter pilot details:");
                    System.out.print("Name: ");
                    String pilotName = userInput.nextLine();
                    System.out.print("Age: ");
                    int pilotAge = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Address: ");
                    String pilotAddress = userInput.nextLine();
                    System.out.print("Flight number: ");
                    String pilotFlightNumber = userInput.nextLine();
                    System.out.print("Max luggage weight: ");
                    double pilotMaxLuggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    Flight pilotFlight = new Flight(pilotFlightNumber, pilotMaxLuggageWeight);
                    Pilot pilot = new Pilot(pilotName, pilotAge, pilotAddress, pilotFlight);
                    System.out.println("Pilot created: " + pilot);
                    break;
                case 5:
                    System.out.println("Enter staff details:");
                    System.out.print("Name: ");
                    String staffName = userInput.nextLine();
                    System.out.print("Age: ");
                    int staffAge = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Address: ");
                    String staffAddress = userInput.nextLine();
                    System.out.print("Flight number: ");
                    String staffFlightNumber = userInput.nextLine();
                    System.out.print("Max luggage weight: ");
                    double staffMaxLuggageWeight = userInput.nextDouble();
                    userInput.nextLine(); // Consume newline
                    Flight staffFlight = new Flight(staffFlightNumber, staffMaxLuggageWeight);
                    Staff staff = new Staff(staffName, staffAge, staffAddress, staffFlight) {};
                    System.out.println("Staff created: " + staff);
                    break;
                case 6:
                    if (currentFlight == null) {
                        System.out.println("Please create a flight first.");
                        break;
                    }
                    currentFlight.savePassengerListToFile();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    userInput.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}