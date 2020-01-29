package Models;

public class OutOfStock {

    int ID;
    private Shoe shoe;

    public OutOfStock(int ID, Shoe shoe) {
        this.ID = ID;
        this.shoe = shoe;
    }

    public int getID() {
        return ID;
    }

    public Shoe getShoe() {
        return shoe;
    }
}
