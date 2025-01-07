package objects.flight;

public class Flight {
    private int flightNumber;
    private String destination;
    private int economySeats;
    private int businessSeats;


    public Flight(int flightNumber, String destination, int economySeats, int businessSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
    }
}
