package objects.person;

import objects.flight.Flight;
/**
 * De abstracte klasse Person vormt de basis voor iedere persoon in het systeem, inclusief passagiers en personeel.
 * Deze klasse bevat algemene attributen zoals naam, leeftijd, adres en een vlucht.
 */
public abstract class Person {

    /**
     * Naam van de persoon.
     */
    private String name;

    /**
     * Leeftijd van de persoon.
     */
    private int age;

    /**
     * Adres van de persoon.
     */
    private String address;

    /**
     * De vlucht waaraan de persoon gekoppeld is.
     */
    private Flight flight;

    /**
     * Constructor die een object van de klasse Person maakt met opgegeven attributen.
     *
     * @param name    Naam van de persoon.
     * @param age     Leeftijd van de persoon.
     * @param address Adres van de persoon.
     * @param flight  De vlucht die bij de persoon hoort.
     */
    public Person(String name, int age, String address, Flight flight) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.flight = flight;
    }

    /**
     * Standaardconstructor voor de klasse Person.
     */
    public Person() {
    }

    // Getters en setters

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", flight=" + flight +
                '}';
    }
}

