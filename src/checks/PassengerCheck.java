package checks;

public interface PassengerCheck {

    public default boolean checkPassenger(){
      return true;
    };

}
