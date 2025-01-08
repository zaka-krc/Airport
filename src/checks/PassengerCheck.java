package checks;

public interface PassengerCheck {

    default boolean checkPassenger(int plannedPersons, int persons){
        return persons == plannedPersons;

    }

}
