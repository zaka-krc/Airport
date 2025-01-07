package objects.person.non_staff.luggage;

public class Luggage {
    private double weight;
    private String owner;

    public Luggage(double weight, String owner) {
        this.weight = weight;
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public String getOwner() {
        return owner;
    }
}
