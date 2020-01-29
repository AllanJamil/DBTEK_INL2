package Models;

public class Shoe {

    private int shoe_ID;
    private String name;
    private Color color;
    private ShoeSize shoeSize;
    private Brand brand;
    private Price price;
    private InStock inStock;

    public Shoe(int shoe_ID, String name, Color color, ShoeSize shoeSize, Brand brand, Price price, InStock inStock) {
        this.shoe_ID = shoe_ID;
        this.name = name;
        this.color = color;
        this.shoeSize = shoeSize;
        this.brand = brand;
        this.price = price;
        this.inStock = inStock;
    }

    public Shoe() {

    }

    public int getShoe_ID() {
        return shoe_ID;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public ShoeSize getShoeSize() {
        return shoeSize;
    }

    public Brand getBrand() {
        return brand;
    }

    public Price getPrice() {
        return price;
    }

    public InStock getInStock() {
        return inStock;
    }
}
