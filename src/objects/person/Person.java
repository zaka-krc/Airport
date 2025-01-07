package objects.person;

public abstract class Person {
    private String name;
    private int age;
    private String adress;
    private int flightNumber;

    public Person(String name, int age, String adress, int flightNumber) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.flightNumber = flightNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAdress() {
        return adress;

    }
}
