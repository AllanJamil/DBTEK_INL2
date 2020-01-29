package ViewModels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductCart {

    int ID;
    private SimpleStringProperty name;
    private SimpleStringProperty brand;
    private SimpleStringProperty color;
    private SimpleIntegerProperty size;
    private SimpleIntegerProperty price;
    private int sold;

    public ProductCart(int ID, String name, String brand, String color, int size, int price) {
        this.ID = ID;
        this.name = new SimpleStringProperty(name);
        this.brand = new SimpleStringProperty(brand);
        this.color = new SimpleStringProperty(color);
        this.size = new SimpleIntegerProperty(size);
        this.price = new SimpleIntegerProperty(price);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public int getSize() {
        return size.get();
    }

    public SimpleIntegerProperty sizeProperty() {
        return size;
    }

    public int getPrice() {
        return price.get();
    }
}
