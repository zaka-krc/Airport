package objects.flight;


import objects.person.non_staff.Passenger;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private int seatChoice;
    public enum typeSeat {
        BUSINESS, ECONOMY
    }

    public Ticket(Flight flight, Passenger passenger, int seatChoice) {
        this.flight = flight;
        this.passenger = passenger;
        this.seatChoice = seatChoice;
        }

    public void setSeatChoice(int seatChoice) {
        switch (seatChoice) {
            case 1:
                //typeSeat.BUSINESS;
                break;
            case 2:
                //typeSeat.ECONOMY;
                break;
            default:
                throw new IllegalArgumentException("Invalid seatChoice. Must be Business or 2 Economy.");
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }



    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


}