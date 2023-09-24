package data;

public class PrestaUser {

    private final String email;
    private final String pass;
    private final String name;
    private final String lastName;
    private final String birthdayDate;


    public PrestaUser(String email, String pass, String name, String lastName, String birthdayDate) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public static PrestaUser getAdmin() {
        return new PrestaUser("kalakaynazar@gmail.com", "32714@Nazar", "Nazar", "Kalakai", "01/25/1999");
    }
}
