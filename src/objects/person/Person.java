package objects.person;

import objects.flight.Flight;

public abstract class Person {
    private String name;
    private int age;
    private String adress;
    private Flight flight;

    public Person(String name, int age, String adress, int flightNumber) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.flight = new Flight();
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getAdress() {
        return adress;

    }
}
