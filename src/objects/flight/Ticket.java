package objects.flight;

public class Ticket {
    private String passenger;
    private String typeSeat;
    private int flightID;

    public Ticket(String passenger, String typeSeat, int flightID) {
        this.passenger = passenger;
        this.typeSeat = typeSeat;
        this.flightID = flightID;
    }
}
