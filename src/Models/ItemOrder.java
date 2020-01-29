package Models;


public class ItemOrder {

    private int ID;
    private CustomerOrder customerOrder;
    private Shoe shoe;

    public ItemOrder(int ID, CustomerOrder customerOrder, Shoe shoe) {
        this.ID = ID;
        this.customerOrder = customerOrder;
        this.shoe = shoe;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public int getID() {
        return ID;
    }
}
