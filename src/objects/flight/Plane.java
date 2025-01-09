package objects.flight;

import objects.person.Person;
import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;
import objects.flight.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * De klasse beschrijft een vliegtuig met informatie over personeel, passagiers,
 * vluchtgegevens en vliegtuigcapaciteit.
 */
public class Plane {

    /**
     * De maximale capaciteit van passagiers in het vliegtuig.
     */
    private final int planeCapacity;

    /**
     * Een lijst van medewerkers (personeel) aanwezig in het vliegtuig.
     */
    private List<Staff> staffList = new ArrayList<>();

    /**
     * Een lijst van passagiers aanwezig in het vliegtuig.
     */
    private List<Passenger> passengerList = new ArrayList<>();

    /**
     * De vlucht die gekoppeld is aan het vliegtuig.
     */
    private Flight flight;

    /**
     * Constructor om een nieuw vliegtuig te maken.
     *
     * @param planeCapacity De maximale capaciteit van het vliegtuig.
     * @param flight De vlucht die aan dit vliegtuig gekoppeld is.
     */
    public Plane(int planeCapacity, Flight flight) {
        this.planeCapacity = planeCapacity;
        this.flight = flight;
    }

    /**
     * Retourneert de capaciteit van het vliegtuig.
     *
     * @return De maximale capaciteit.
     */
    public int getPlaneCapacity() {
        return planeCapacity;
    }

    /**
     * Retourneert de lijst van personeel in het vliegtuig.
     *
     * @return Een lijst van {@link Staff}.
     */
    public List<Staff> getStaffList() {
        return staffList;
    }

    /**
     * Stelt de lijst van personeel in.
     *
     * @param staffList De nieuwe lijst van personeel.
     */
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    /**
     * Retourneert de lijst van passagiers in het vliegtuig.
     *
     * @return Een lijst van {@link Passenger}.
     */
    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    /**
     * Stelt de lijst van passagiers in.
     *
     * @param passengerList De nieuwe lijst van passagiers.
     */
    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    /**
     * Retourneert de vlucht die aan het vliegtuig gekoppeld is.
     *
     * @return Een instantie van {@link Flight}.
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Stelt de vlucht die aan het vliegtuig gekoppeld is in.
     *
     * @param flight De nieuwe gekoppelde vlucht.
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Voegt een persoon toe aan het vliegtuig (personeel of passagier).
     *
     * @param person De toe te voegen persoon.
     * @return {@code true} als de persoon succesvol is toegevoegd, anders {@code false}.
     */
    public boolean addPerson(Person person) {
        if (personExists(person)) {
            System.out.println("De persoon zit al in het vliegtuig");
            return false;
        }

        if (person instanceof Passenger) {
            addPassenger((Passenger) person);
            return true;
        } else if (person instanceof Staff) {
            staffList.add((Staff) person);
            return true;
        }
        return false;
    }

    /**
     * Controleert of een persoon al in het vliegtuig aanwezig is.
     *
     * @param person De persoon die gecontroleerd moet worden.
     * @return {@code true} als de persoon al aanwezig is, anders {@code false}.
     */
    private boolean personExists(Person person) {
        if (person instanceof Passenger) {
            return passengerList.stream().anyMatch(p -> p.getName().equals(person.getName()));
        } else if (person instanceof Staff) {
            return staffList.stream().anyMatch(s -> s.getName().equals(person.getName()));
        } else {
            return false;
        }
    }

    /**
     * Voegt een passagier toe aan het vliegtuig als er beschikbare stoelen zijn.
     *
     * @param passenger De passagier die toegevoegd moet worden.
     * @return {@code true} als de passagier is toegevoegd, anders {@code false}.
     */
    private boolean addPassenger(Passenger passenger) {
        Ticket ticket = passenger.getTicket();
        if (ticket.getSeatChoice() == Ticket.typeSeat.BUSINESS) {
            if (getPassengerList().size() >= planeCapacity) {
                System.out.println("Het vliegtuig is vol");
                return false;
            }

            if (flight.getBusinessSeats() > 0) {
                flight.setBusinessSeats(flight.getBusinessSeats() - 1);
                passengerList.add(passenger);
                return true;
            } else {
                System.out.println("Geen beschikbare business stoelen");
                return false;
            }
        } else if (ticket.getSeatChoice() == Ticket.typeSeat.ECONOMY) {
            if (flight.getEconomySeats() > 0) {
                flight.setEconomySeats(flight.getEconomySeats() - 1);
                passengerList.add(passenger);
                return true;
            } else {
                System.out.println("Geen beschikbare economy stoelen");
                return false;
            }
        }
        return false;
    }

    /**
     * Retourneert een stringrepresentatie van het vliegtuig.
     *
     * @return Een string met details over het vliegtuig.
     */
    @Override
    public String toString() {
        return "Plane{" +
                "planeCapacity=" + planeCapacity +
                ", staffList=" + staffList +
                ", passengerList=" + passengerList +
                ", flight=" + flight +
                '}';
    }
}