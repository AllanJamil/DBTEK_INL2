package Models;

import java.util.Date;

public class CustomerOrder {

    private int ID;
    private Customer customer;
    private Date date;

    public CustomerOrder(int ID, Customer customer, Date date) {
        this.ID = ID;
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }
}
