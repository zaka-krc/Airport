package objects.flight;

import objects.person.staff.FlightAttendant;
import objects.person.staff.Pilot;

/**
 * Vertegenwoordigt een vlucht inclusief informatie over vluchtnummer, bestemmingen,
 * stoelcapaciteit, vliegtuig en maximaal bagagegewicht.
 */
public class Flight {

    /**
     * Het unieke vluchtnummer.
     */
    private int flightNumber;

    /**
     * De eindbestemming van de vlucht.
     */
    private String endDestination;

    /**
     * De beginbestemming van de vlucht.
     */
    private String startDestination;

    /**
     * Aantal beschikbare business class stoelen.
     */
    private int businessSeats;

    /**
     * Aantal beschikbare economy class stoelen.
     */
    private int economySeats;

    /**
     * Het toegewezen vliegtuig voor deze vlucht.
     */
    private Plane plane;

    /**
     * Het maximale totale bagagegewicht per vlucht.
     */
    private double maxLuggageWeight;

    /**
     * Maakt een nieuwe vlucht aan.
     *
     * @param flightNumber Het unieke vluchtnummer.
     * @param startDestination De beginbestemming van de vlucht.
     * @param endDestination De eindbestemming van de vlucht.
     * @param economySeats Aantal beschikbare economy class stoelen.
     * @param businessSeats Aantal beschikbare business class stoelen.
     * @param maxLuggageWeight Het maximale bagagegewicht per vlucht.
     */
    public Flight(int flightNumber, String startDestination, String endDestination, int economySeats, int businessSeats, double maxLuggageWeight) {
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.flightNumber = flightNumber;
        this.maxLuggageWeight = maxLuggageWeight;
    }

    /**
     * Creëert een ticket voor deze vlucht.
     *
     * @param typeSeat Het type stoel (business/economy).
     * @return Een nieuw ticket dat aan deze vlucht gekoppeld is.
     */
    public Ticket createTicket(Ticket.typeSeat typeSeat) {
        return new Ticket(typeSeat, this.flightNumber);
    }

    /**
     * Wijzigt het unieke vluchtnummer.
     *
     * @param flightNumber Het nieuwe vluchtnummer.
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Retourneert het aantal business class stoelen.
     *
     * @return Aantal business class stoelen.
     */
    public int getBusinessSeats() {
        return businessSeats;
    }

    /**
     * Wijzigt het aantal business class stoelen.
     *
     * @param businessSeats Het nieuwe aantal business class stoelen.
     */
    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    /**
     * Retourneert het aantal economy class stoelen.
     *
     * @return Aantal economy class stoelen.
     */
    public int getEconomySeats() {
        return economySeats;
    }

    /**
     * Wijzigt het aantal economy class stoelen.
     *
     * @param economySeats Het nieuwe aantal economy class stoelen.
     */
    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    /**
     * Retourneert het vluchtnummer.
     *
     * @return Het vluchtnummer.
     */
    public int getFlightNumber() {
        return flightNumber;
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

    /**
     * Retourneert het maximale bagagegewicht.
     *
     * @return Het maximale bagagegewicht.
     */
    public double getMaxLuggageWeight() {
        return maxLuggageWeight;
    }

    /**
     * Controleert of de vlucht klaar is voor vertrek.
     *
     * @param flight De vlucht die gecontroleerd wordt.
     * @param plane Het vliegtuig dat voor deze vlucht wordt gebruikt.
     * @return True als de vlucht klaar is voor vertrek, anders false.
     */
    public boolean flightCheck(Flight flight, Plane plane) {
        int pilotCount = (int) plane.getStaffList().stream().filter(s -> (s instanceof Pilot)).count();
        int flightAttendantCount = (int) plane.getStaffList().stream().filter(s -> (s instanceof FlightAttendant)).count();

        if (pilotCount == 0) {
            System.out.println("Flight is not ready to take off: No pilots on the plane.");
            return false;
        }
        if (flightAttendantCount == 0) {
            System.out.println("Flight is not ready to take off: No flight attendants on the plane.");
            return false;
        }
        if (pilotCount < 2) {
            System.out.println("Flight is not ready to take off: Not enough pilots.");
            return false;
        }
        if (flightAttendantCount <= 2) {
            System.out.println("Flight is not ready to take off: Not enough flight attendants.");
            return false;
        }
        if (!checkPassengers(plane)) {
            System.out.println("Flight is not ready to take off: Passenger count mismatch.");
            return false;
        }
        System.out.println("Flight is ready to take off.");
        return true;
    }


    /**
     * Controleert of het aantal passagiers binnen de capaciteit van het vliegtuig valt.
     *
     * @param plane Het vliegtuig dat gecontroleerd wordt.
     * @return True als het aantal passagiers binnen de capaciteit ligt, anders false.
     */
    public boolean checkPassengers(Plane plane) {
        return plane.getPassengerList().size() <= plane.getPlaneCapacity();

    }

    /**
     * Retourneert een stringrepresentatie van de vlucht.
     *
     * @return Een string met vluchtdetails.
     */
    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", endDestination='" + endDestination + '\'' +
                ", startDestination='" + startDestination + '\'' +
                ", businessSeats=" + businessSeats +
                ", economySeats=" + economySeats +
                ", plane=" + plane +
                ", maxLuggageWeight=" + maxLuggageWeight +
                '}';
    }
}