package objects.flight;

public class Plane extends Flight {
    public final int numberPersons;
    private String endDestination;
    private String startDestination;
    private int flightNumber;

    public Plane(int flightNumber, String destination, int economySeats, int businessSeats, int numberPersons, String endDestination, String startDestination, int flightNumber1) {
        super(flightNumber, destination, economySeats, businessSeats);
        this.numberPersons = numberPersons;
        this.endDestination = endDestination;
        this.startDestination = startDestination;
        this.flightNumber = flightNumber1;
    }

    public int getNumberPersons() {
        return numberPersons;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public String getStartDestination() {
        return startDestination;
    }

    @Override
    public int getFlightNumber() {
        return flightNumber;
    }
}

