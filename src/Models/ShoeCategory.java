package Models;

import java.util.LinkedList;
import java.util.List;

public class ShoeCategory {

    int ID;
    private Shoe shoe;
    private List<Category> categories = new LinkedList<>();

    public ShoeCategory(int ID, Shoe shoe, List<Category> categories) {
        this.ID = ID;
        this.shoe = shoe;
        this.categories = categories;
    }

    public int getID() {
        return ID;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
