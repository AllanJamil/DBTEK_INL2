package Models;

public class City {

    int ID;
    String name;

    public City(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
