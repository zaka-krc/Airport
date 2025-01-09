package objects.flight;

public class Flight {
    private int flightNumber;
    private int numberOfPassengers;
    private String endDestination;
    private String startDestination;
    private int businessSeats;
    private int economySeats;
    private Plane plane;
    private double maxLuggageWeight;

    public Flight(int flightNumber, int numberOfPassengers, String startDestination, String endDestination, int economySeats, int businessSeats, double maxLuggageWeight) {        this.maxLuggageWeight = maxLuggageWeight;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.numberOfPassengers = numberOfPassengers;
        this.flightNumber = flightNumber;
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getFlightNumber () {
            return flightNumber;
        }

        public String getEndDestination () {
            return endDestination;
        }

        public void setEndDestination (String endDestination){
            this.endDestination = endDestination;
        }

        public String getStartDestination () {
            return startDestination;
        }

        public void setStartDestination (String startDestination){
            this.startDestination = startDestination;
        }

        public Plane getPlane () {
            return plane;
        }

        public void setPlane (Plane plane){
            this.plane = plane;
        }

        public double getMaxLuggageWeight () {
            return maxLuggageWeight;
        }

        public int getNumberOfPassengers () {
            return numberOfPassengers;
        }

        public void setNumberOfPassengers ( int numberOfPassengers){
            this.numberOfPassengers = numberOfPassengers;
        }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", numberOfPassengers=" + numberOfPassengers +
                ", endDestination='" + endDestination + '\'' +
                ", startDestination='" + startDestination + '\'' +
                ", plane=" + plane +
                ", maxLuggageWeight=" + maxLuggageWeight +
                '}';
    }
}
