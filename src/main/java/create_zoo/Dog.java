package create_zoo;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, 4, 0);
    }

    @Override
    public void fly() {
        System.out.println("He can't fly");
    }


    public String toString() {

        return "1.This is dog with name " + name + " and he has " + numberOfLegs + " Legs and " + numberOfWings + " wings";
    }
}
