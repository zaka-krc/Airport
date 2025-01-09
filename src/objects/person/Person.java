package objects.person;

import objects.flight.Flight;

public abstract class Person {
    private String name;
    private int age;
    private String address;
    private Flight flight;

    public Person(String name, int age, String address, Flight flight) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.flight = flight;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}