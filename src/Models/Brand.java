package Models;

public class Brand {

    private int ID;
    private String name;

    public Brand(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Brand() {
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
