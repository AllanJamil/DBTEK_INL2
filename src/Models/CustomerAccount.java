package Models;

public class CustomerAccount {

    private int ID;
    private Customer customer;
    private String userName;
    private String password;

    public CustomerAccount(int ID, Customer customer, String userName, String password) {
        this.ID = ID;
        this.customer = customer;
        this.userName = userName;
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }
}
