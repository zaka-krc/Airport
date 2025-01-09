import objects.flight.Flight;
import objects.flight.Plane;
import objects.flight.Ticket;
import objects.person.non_staff.Passenger;
import objects.person.staff.FlightAttendant;
import objects.person.staff.LuggageAttendant;
import objects.person.staff.Pilot;
import objects.person.staff.Staff;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * De Main-klasse biedt een instappunt voor het beheren van vluchten, vliegtuigen, passagiers en personeel.
 * Het omvat functionaliteiten zoals het aanmaken van vluchten en vliegtuigen, toevoegen van passagiers en personeel,
 * uitvoeren van vluchtcontroles en het afdrukken van vluchtinformatie naar een bestand.
 */
public class Main {

    /**
     * Vertegenwoordigt de huidige vlucht die wordt beheerd.
     */
    private static Flight flight;

    /**
     * Vertegenwoordigt het vliegtuig dat is gekoppeld aan de huidige vlucht.
     */
    private static Plane plane;

    /**
     * Scanner-object dat wordt gebruikt voor het verzamelen van gebruikersinput vanaf de console.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * De main-methode fungeert als het instappunt voor de applicatie. Het biedt een menu voor het beheren
     * van vluchtgerelateerde acties, zoals het aanmaken van vluchten, toevoegen van passagiers of personeel,
     * uitvoeren van vluchtcontroles en exporteren van vluchtinformatie.
     *
     * @param args Command-line argumenten
     */
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
                    createPassenger();
                    break;
                case 3:
                    addStaff();
                    break;
                case 4:
                    flight.flightCheck(flight, plane);
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

    /**
     * Maakt een nieuwe vlucht en een gekoppeld vliegtuig door gebruikersinput te vragen
     * voor vluchtgegevens zoals vluchtnummer, bestemmingen, bagagegewicht, aantal stoelen en vliegtuigcapaciteit.
     */
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
        flight = new Flight(flightNumber, startDestination, endDestination, economySeats, businessSeats, maxLuggageWeight);
        plane = new Plane(planeCapacity, flight);
        System.out.println("Flight and Plane created successfully.");
    }

    /**
     * Voegt een nieuwe passagier toe aan de vlucht als de opgegeven gegevens geldig zijn, waaronder vluchtnummer,
     * stoeltype en bagagegewicht. Controleert of het bagagegewicht niet buiten de limieten valt.
     */
    private static void createPassenger() {
        System.out.println("Enter flight number: ");
        int flightNr = getIntInput();
        scanner.nextLine();
        if (flightNr != flight.getFlightNumber()) {
            System.out.println("Invalid flight number. Passenger not added.");
            return;
        }
        System.out.println("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.println("Enter passenger age: ");
        int age = getIntInput();
        scanner.nextLine();
        System.out.println("Enter passenger address: ");
        String address = scanner.nextLine();
        System.out.println("Enter luggage weight: ");
        int luggageWeight = getIntInput();
        scanner.nextLine();
        if (luggageWeight > flight.getMaxLuggageWeight()) {
            System.out.println("Luggage weight exceeds the maximum allowed weight. Passenger not added.");
            return;
        }
        System.out.println("Enter seat type: 1. Business 2. Economy ");
        int seatChoice = getIntInput();
        scanner.nextLine();
        if (seatChoice != 1 && seatChoice != 2) {
            System.out.println("Invalid seat choice. Passenger not added.");
            return;
        }
        Passenger passenger = new Passenger(name, age, address, flight, luggageWeight, flight.createTicket(Ticket.typeSeat.values()[seatChoice - 1]));
        if (plane.addPerson(passenger)) {
            System.out.println("Passenger added successfully.");
        }
    }

    /**
     * Voegt een personeelslid toe aan de vlucht. Ondersteunt meerdere personeelssoorten:
     * Flight Attendant, Luggage Attendant en Pilot. Valideert vluchtgegevens voordat
     * het personeelslid wordt toegevoegd.
     */
    private static void addStaff() {
        System.out.println("Enter staff type: 1.Flight Attendant 2. Luggage Attendant 3. Pilot ");
        int staffTypeChoice = getIntInput();
        scanner.nextLine();
        System.out.println("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.println("Enter staff age: ");
        int age = getIntInput();
        scanner.nextLine();
        System.out.println("Enter staff address: ");
        String address = scanner.nextLine();
        System.out.println("Enter flight number: ");
        int flightNr = getIntInput();
        scanner.nextLine();
        if (flightNr != flight.getFlightNumber()) {
            System.out.println("Invalid flight number. Staff not added.");
            return;
        }
        Staff.StaffType staffType;
        Staff staff;
        String staffChoice;
        switch (staffTypeChoice) {
            case 1:
                staffType = Staff.StaffType.FLIGHT_ATTENDANT;
                staff = new FlightAttendant(name, age, address, flight, staffType);
                staffChoice = "Flight Attendant";
                break;
            case 2:
                staffType = Staff.StaffType.LUGGAGE_ATTENDANT;
                staff = new LuggageAttendant(name, age, address, flight, staffType);
                staffChoice = "Luggage Attendant";
                break;
            case 3:
                staffType = Staff.StaffType.PILOT;
                staff = new Pilot(name, age, address, flight, staffType);
                staffChoice = "Pilot";
                break;
            default:
                System.out.println("Invalid staff type. Staff not added.");
                return;
        }
        if (plane.addPerson(staff)) {
            System.out.println(staffChoice + " added successfully.");
        }
    }

    /**
     * Slaat vluchtinformatie, inclusief passagiers- en personeelsgegevens, op in een tekstbestand.
     * De bestandsnaam wordt gegenereerd aan de hand van het vluchtnummer.
     */
    private static void printFlightInfo() {
        String fileName = "src/flights/" + (flight.getFlightNumber() + ".txt");
        String flightInfo = "Flight Number: " + flight.getFlightNumber() + "\n"
                + "Departure: " + flight.getStartDestination() + "\n"
                + "Destination: " + flight.getEndDestination() + "\n"
                + "Passenger List: " + plane.getPassengerList() + "\n"
                + "Staff List: " + plane.getStaffList() + "\n"
                + "Max Luggage Weight: " + flight.getMaxLuggageWeight() + "\n"
                + "Number of Economy Seats: " + flight.getEconomySeats() + "\n"
                + "Number of Business Seats: " + flight.getBusinessSeats() + "\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(flightInfo);
            System.out.println("Flight information successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while writing the flight information to the file: " + e.getMessage());
        }
    }

    /**
     * Leest een geheel getal in van de gebruikersinput. Als de invoer ongeldig is,
     * blijft het de gebruiker vragen om een geldig geheel getal in te voeren.
     *
     * @return Een geldig geheel getal ingevoerd door de gebruiker
     */
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Leest een double-waarde in van de gebruikersinput. Als de invoer ongeldig is,
     * blijft het de gebruiker vragen om een geldige waarde in te voeren.
     *
     * @return Een geldige double-waarde ingevoerd door de gebruiker
     */
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}