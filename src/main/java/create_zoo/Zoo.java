package create_zoo;

public class Zoo {
    public static void main(String[] args) {
        Dog beagle = new Dog("Badi");
        System.out.println(beagle.toString());
        beagle.fly();
        beagle.swim();

        Fish clownfish = new Fish("Nemo");
        System.out.println(clownfish.toString());
        clownfish.fly();
        clownfish.swim();

        Bird pelican = new Bird("Gerald");
        System.out.println(pelican.toString());
        pelican.fly();
        pelican.swim();
    }
}
