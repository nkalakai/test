package making_orders;

public class Product {
    private double price;
    private String productName;
    private String productManufacturer;


    public Product(String productName, String productManufacturer, double price) {
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        setPrice(price);
    }

    public double getPrice() {

        return this.price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    public String getProductName() {

        return productName;
    }

    public String getProductManufacturer() {

        return productManufacturer;
    }

    @Override
    public String toString() {
        return getProductName() + " by " + getProductManufacturer();
    }
}
