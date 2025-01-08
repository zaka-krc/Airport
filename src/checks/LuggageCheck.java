package checks;

public interface LuggageCheck {

    public default boolean checkLuggage(double maxWeight, double weight){
        return weight <= maxWeight;
    };
}
