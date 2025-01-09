package objects.person.staff;

public class Pilot extends Staff {
    private FlightAttendant flightAttendant;
    private LuggageAttendant luggageAttendant;

    public Pilot(String name, int age, String adress, int flightNr) {
        super(name, age, adress, flightNr);
    }

    public String flightCheck (){
        if (flightAttendant.checkPassenger() && luggageAttendant.checkLuggage()){
            return "Flight is ready to take off";
        } else {
            return "Flight is not ready to take off";
        }
    }

}
