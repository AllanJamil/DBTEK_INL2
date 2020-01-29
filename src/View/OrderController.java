package View;

import Models.Shoe;
import Repository.OrderRepository;
import Repository.ShoeRepository;
import ViewModels.Product;
import ViewModels.ProductCart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.*;

public class OrderController implements Initializable {

    OrderRepository or = new OrderRepository();
    ShoeRepository sr = new ShoeRepository();

    LogInController logInController = new LogInController();
    private int total;
    private List<ProductCart> productCarts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    @FXML
    private Label label_total;
    @FXML
    private TableView<ProductCart> table_cart;
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, String> col_shoe;
    @FXML
    private TableColumn<Product, String> col_brand;
    @FXML
    private TableColumn<Product, String> col_color;
    @FXML
    private TableColumn<Product, Integer> col_size;
    @FXML
    private TableColumn<Product, Integer> col_price;
    @FXML
    private TableColumn<Product, Integer> col_stock;
    @FXML
    private TableColumn<ProductCart, String> col_cart_Shoe;
    @FXML
    private TableColumn<ProductCart, String> col_cart_brand;
    @FXML
    private TableColumn<ProductCart, String> col_cart_color;
    @FXML
    private TableColumn<ProductCart, Integer> col_cart_size;
    @FXML
    private TableColumn<ProductCart, Integer> col_cart_price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_shoe.setCellValueFactory(new PropertyValueFactory<>("shoeName"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("shoeBrand"));
        col_color.setCellValueFactory(new PropertyValueFactory<>("shoeColor"));
        col_size.setCellValueFactory(new PropertyValueFactory<>("shoeSize"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("shoePrice"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        col_cart_Shoe.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_cart_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_cart_color.setCellValueFactory(new PropertyValueFactory<>("color"));
        col_cart_size.setCellValueFactory(new PropertyValueFactory<>("size"));
        col_cart_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        getProducts();
        table_cart.setItems(observableListC);
        tableProduct.setItems(observableList);
    }

    ObservableList<Product> observableList = FXCollections.observableArrayList();
    ObservableList<ProductCart> observableListC = FXCollections.observableArrayList();


    public void getProducts() {

        List<Shoe> shoes = sr.getAllShoes();

        shoes.forEach(shoe -> this.products.add(new Product(shoe.getShoe_ID(), shoe.getName(), shoe.getBrand().getName(),
                shoe.getColor().getName(), shoe.getShoeSize().getShoeSize(), shoe.getInStock().getStock(),
                shoe.getPrice().getPrice())));

        products.forEach(item -> productCarts.add(new ProductCart(item.getID(), item.getShoeName(), item.getShoeBrand(),
                item.getShoeColor(), item.getShoeSize(), item.getShoePrice())));

        products.forEach(product -> observableList.add(product));
    }

    @FunctionalInterface
    interface ButtonAction {
        void perform();
    }

    public void actionOnButtonPress(ButtonAction buttonAction) {
        buttonAction.perform();
    }

    public void addButton() {

        actionOnButtonPress(() -> {
            ProductCart productCart;
            Product product = tableProduct.getSelectionModel().getSelectedItem();
            productCart = new ProductCart(product.getID(), product.getShoeName(), product.getShoeBrand(),
                    product.getShoeColor(), product.getShoeSize(), product.getShoePrice());


            if (product.getStock() != 0) {
                table_cart.getItems().add(productCart);
            }
            updateStock();
            updateTotal();
        });


    }

    public void removeButton() {

        if (table_cart.getSelectionModel().getFocusedIndex() != -1) {
            ProductCart productCart = table_cart.getSelectionModel().getSelectedItem();
            table_cart.getItems().remove(productCart);

            tableProduct.getItems().forEach(item -> {
                if (item.getID() == productCart.getID()) {
                    item.setStock(item.getStock() + 1);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "You have to select an item to remove it.");
        }
        updateTotal();
    }

    public void makeOrder() {
        int orderNumber = or.getNewOrder();
        if (!table_cart.getItems().isEmpty()) {
            table_cart.getItems().forEach(item -> {
                or.makeOrder(logInController.getCustomer_ID(), orderNumber, item.getID());
            });
        }
        table_cart.getItems().clear();

        updateTotal();
    }

    public void updateTotal() {
        total = 0;
        table_cart.getItems().forEach(productCart -> total += productCart.getPrice());
        label_total.setText(total + "");
    }

    public void updateStock() {
        Product product = tableProduct.getSelectionModel().getSelectedItem();
        if (product.getStock() != 0) {
            product.setStock(product.getStock() - 1);
        }
    }
}
