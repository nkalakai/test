package making_orders;

public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    private boolean payed;
    private boolean delivered;
    private double orderValue;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.calculateOrderValue();
    }

    public Customer getCustomer() {

        return customer;
    }

    public Product getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = Math.max(0, quantity);
        calculateOrderValue();
    }

    public boolean isPayed() {

        return payed;
    }

    public void setPayed(boolean payed) {

        this.payed = payed;
    }

    public boolean isDelivered() {

        return delivered;
    }

    public void setDelivered(boolean delivered) {

        this.delivered = delivered;
    }

    void calculateOrderValue() {

        this.orderValue = product.getPrice() * quantity;
    }

    public double getOrderValue() {

        return orderValue;
    }

    @Override
    public String toString() {
        return "Customer: " + getCustomer() + "\n"
                + "Product: " + getProduct() + "\n"
                + "OrderValue: " + getOrderValue();
    }
}
