package create_zoo;

public class Bird extends Animal {
    public Bird(String name) {
        super(name, 2, 2);
    }

    public String toString() {
        return "3.This is bird with name " + name + " and he has " + numberOfLegs + " legs and " +
                numberOfWings + " wings";
    }
}
