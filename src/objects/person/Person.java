package objects.person;

public abstract class Person {
    private String name;
    private int age;
    private String adress;

    public Person(String name, int age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }
}
