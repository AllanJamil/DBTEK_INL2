package Models;

public class InStock {

    int ID;
    int stock;

    public InStock(int ID, int stock) {
        this.ID = ID;
        this.stock = stock;
    }

    public InStock() {

    }

    public int getID() {
        return ID;
    }

    public int getStock() {
        return stock;
    }
}
