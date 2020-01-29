package Models;

public class Customer {

    private int ID;
    private String firstName;
    private String lastName;
    private City city;

    public Customer(int ID, String firstName, String lastName, City city) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public City getCity() {
        return city;
    }

    public int getID() {
        return ID;
    }
}
