package Models;

public class Color {

    private int ID;
    private String name;

    public Color(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Color() {

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
