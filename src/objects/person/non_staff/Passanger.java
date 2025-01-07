package objects.person.non_staff;
import objects.person.Person;

public class Passanger extends Person {
    private String typeSeat;
    private int luggages;

    public Passanger(String name, int age, String adress, String typeSeat, int luggages) {
        super(name, age, adress);
        this.typeSeat = typeSeat;
        this.luggages = luggages;
    }
}
