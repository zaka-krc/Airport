package objects.flight;


import objects.person.non_staff.Passenger;

/**
 * Deze klasse vertegenwoordigt een ticket met informatie over het vluchtnummer
 * en de gekozen stoeloptie (business of economy).
 */
public class Ticket {

    /**
     * Het vluchtnummer waaraan het ticket is gekoppeld.
     */
    private int flightNumber;

    /**
     * De stoelkeuze, business of economy.
     */
    private typeSeat seatChoice;

    /**
     * Een enum die de beschikbare stoeltypes vertegenwoordigt.
     */
    public enum typeSeat {
        BUSINESS, ECONOMY
    }

    /**
     * Maakt een nieuw ticket aan met het opgegeven stoetype en vluchtnummer.
     *
     * @param seatChoice De gekozen stoeloptie (business of economy).
     * @param flightNumber Het vluchtnummer waaraan het ticket is gekoppeld.
     */
    public Ticket(typeSeat seatChoice, int flightNumber) {
        this.seatChoice = seatChoice;
        this.flightNumber = flightNumber;
    }

    /**
     * Wijzigt de stoelkeuze op basis van een integerwaarde.
     *
     * @param seatChoice De numerieke stoelkeuze: 1 voor business, 2 voor economy.
     */
    public void setSeatChoice(int seatChoice) {
        switch (seatChoice) {
            case 1:
                this.seatChoice = typeSeat.BUSINESS;
                break;
            case 2:
                this.seatChoice = typeSeat.ECONOMY;
                break;
            default:
                System.out.println("Ongeldige stoelkeuze. Kies Business of Economy.");
        }
    }

    /**
     * Retourneert de huidige stoelkeuze.
     *
     * @return De gekozen stoeloptie (business of economy).
     */
    public typeSeat getSeatChoice() {
        return seatChoice;
    }

    /**
     * Wijzigt de stoelkeuze.
     *
     * @param seatChoice De nieuwe stoelkeuze (business of economy).
     */
    public void setSeatChoice(typeSeat seatChoice) {
        this.seatChoice = seatChoice;
    }

    /**
     * Retourneert een stringrepresentatie van het ticket.
     *
     * @return Een string die informatie over het ticket geeft, zoals vluchtnummer en stoelkeuze.
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "flightNumber=" + flightNumber +
                ", seatChoice=" + seatChoice +
                '}';
    }
}