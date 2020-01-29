package Models;

public class Price {

    private int ID;
    private int price;

    public Price(int ID, int price) {
        this.ID = ID;
        this.price = price;
    }

    public Price() {

    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }
}
