package create_zoo;

public class Fish extends Animal {
    public Fish(String name) {
        super(name, 0, 0);
    }

    @Override
    public void fly() {
        System.out.println("He can't fly");
    }


    public String toString() {
        return "2.This is fish with name " + name + " and this fish has " + numberOfLegs + " legs and " + numberOfWings + " wings";
    }
}
