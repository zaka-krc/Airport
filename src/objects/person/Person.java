package objects.person;

import objects.flight.Flight;

public abstract class Person {
    private String name;
    private int age;
    private String adress;
    private Flight flight;

    public Person(String name, int age, String adress, int flightNr) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        flight.getFlightNumber();
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


    public int getAge() {
        return age;
    }


    public String getAdress() {
        return adress;

    }
}
