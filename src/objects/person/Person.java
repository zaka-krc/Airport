package objects.person;

import objects.flight.Flight;

public abstract class Person {
    private String name;
    private int age;
    private String adress;
    private int flightNr;

    public Person(String name, int age, String adress, int flightNr) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.flightNr = flightNr;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setFlightNr(int flightNr) {
        this.flightNr = flightNr;
    }

    public int getAge() {
        return age;
    }

    public int getFlightNr() {
        return flightNr;
    }

    public String getAdress() {
        return adress;

    }
}
