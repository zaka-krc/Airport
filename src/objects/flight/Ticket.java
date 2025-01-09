package objects.flight;


import objects.person.non_staff.Passenger;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private typeSeat seatChoice;
    public enum typeSeat {
        BUSINESS, ECONOMY
    }

    public Ticket(Flight flight, Passenger passenger, int seatChoice) {
        this.flight = flight;
        this.passenger = passenger;
        setSeatChoice(seatChoice);
        }

    public void setSeatChoice(int seatChoice) {
        switch (seatChoice) {
            case 1:
                this.seatChoice = typeSeat.BUSINESS;
                break;
            case 2:
                this.seatChoice = typeSeat.ECONOMY;
            break;
            default:
                System.out.println("Invalid seatChoice. Must be Business or  Economy.");
        }
    }

    public typeSeat getSeatChoice() {
        return seatChoice;
    }

    public void setSeatChoice(typeSeat seatChoice) {
        this.seatChoice = seatChoice;
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