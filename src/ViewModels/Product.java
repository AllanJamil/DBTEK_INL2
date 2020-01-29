package ViewModels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {

    private int ID;
    private SimpleStringProperty shoeName;
    private SimpleStringProperty shoeBrand;
    private SimpleStringProperty shoeColor;
    private SimpleIntegerProperty shoeSize;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty shoePrice;
    private int sold = 0;

    public Product(int ID, String shoeName, String shoeBrand,
                   String shoeColor, int shoeSize, int stock, int shoePrice) {
        this.ID = ID;
        this.shoeName = new SimpleStringProperty(shoeName);
        this.shoeBrand = new SimpleStringProperty(shoeBrand);
        this.shoeColor = new SimpleStringProperty(shoeColor);
        this.shoeSize = new SimpleIntegerProperty(shoeSize);
        this.stock = new SimpleIntegerProperty(stock);
        this.shoePrice = new SimpleIntegerProperty(shoePrice);
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getID() {
        return ID;
    }

    public String getShoeName() {
        return shoeName.get();
    }

    public SimpleStringProperty shoeNameProperty() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName.set(shoeName);
    }

    public String getShoeBrand() {
        return shoeBrand.get();
    }

    public SimpleStringProperty shoeBrandProperty() {
        return shoeBrand;
    }

    public void setShoeBrand(String shoeBrand) {
        this.shoeBrand.set(shoeBrand);
    }

    public String getShoeColor() {
        return shoeColor.get();
    }

    public SimpleStringProperty shoeColorProperty() {
        return shoeColor;
    }

    public void setShoeColor(String shoeColor) {
        this.shoeColor.set(shoeColor);
    }

    public int getShoeSize() {
        return shoeSize.get();
    }

    public SimpleIntegerProperty shoeSizeProperty() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize.set(shoeSize);
    }

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public int getShoePrice() {
        return shoePrice.get();
    }

    public SimpleIntegerProperty shoePriceProperty() {
        return shoePrice;
    }

    public void setShoePrice(int shoePrice) {
        this.shoePrice.set(shoePrice);
    }
}
