package data;

public class PrestaUserAddress {
    private final String address;
    private final String postcode;
    private final String city;

    public PrestaUserAddress(String adress, String postcode, String city) {
        this.address = adress;
        this.postcode = postcode;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public static PrestaUserAddress getAddressUser() {
        return new PrestaUserAddress("La Chapelle", "40724", "Paris");
    }
}
