package Models;

public class ShoeSize {

    private int ID;
    private int shoeSize;

    public ShoeSize(int ID, int shoeSize) {
        this.shoeSize = shoeSize;
        this.ID = ID;
    }

    public ShoeSize() {

    }

    public int getID() {
        return ID;
    }

    public int getShoeSize() {
        return shoeSize;
    }
}
