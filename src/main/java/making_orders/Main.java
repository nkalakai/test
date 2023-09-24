package making_orders;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(" Nazar ", "Kalakai");
        Customer customer2 = new Customer(" Anna ", "Nowak");
        Product product1 = new Product("Smartphone iphone 11", "Apple", 699.60);
        Product product2 = new Product("Airpods pro", "Apple", 195.50);

        Order order1 = new Order(customer1, product1, 2);
        Order order2 = new Order(customer2, product2, 3);

        System.out.println("Order 1:\n" + order1);
        System.out.println("Order 2:\n" + order2);
    }
}
