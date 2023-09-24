package making_orders;

public class Customer {
    private String name;
    private String surname;
    private int clientID;
    private static int nextCustomerId = 100;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.clientID = nextCustomerId;
        nextCustomerId++;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public int getClientID() {

        return clientID;
    }

    @Override
    public String toString() {
        return "ID:" + getClientID() + "\n" + "Name:" + getName() + getSurname();
    }
}
