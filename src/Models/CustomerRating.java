package Models;

public class CustomerRating {

    private int ID;
    private Customer customer;
    private Shoe shoe;
    private Rate rate;
    private String comments;

    public CustomerRating(int ID, Customer customer, Shoe shoe, Rate rate, String comments) {
        this.ID = ID;
        this.customer = customer;
        this.shoe = shoe;
        this.rate = rate;
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public Rate getRate() {
        return rate;
    }

    public String getComments() {
        return comments;
    }

    public int getID() {
        return ID;
    }
}
