package create_zoo;

public class Animal {
    String name;
    int numberOfLegs;
    int numberOfWings;

    public Animal(String name, int numberOfLegs, int numberOfWings) {

        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.numberOfWings = numberOfWings;
    }

    public void fly() {
        System.out.println("He can fly");
    }

    public void swim() {
        System.out.println("He can swim");
    }
}