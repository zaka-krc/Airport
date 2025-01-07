package objects.person.staff;
import checks.LuggageCheck;
import objects.person.Person;

public class LuggageAttendant extends Person implements LuggageCheck {

    public LuggageAttendant(String name, int age, String adress, int flightNumber) {
        super(name, age, adress, flightNumber);
    }

    @Override
    public boolean checkLuggage() {
        return false;
    }
}
