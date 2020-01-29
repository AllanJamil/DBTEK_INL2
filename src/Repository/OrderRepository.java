package Repository;

import javax.swing.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class OrderRepository {

    Properties p = new Properties();

    public OrderRepository() {

        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNewOrder() {
        int newOrderID = 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT MAX(customerorder.customerOrder_ID)" +
                    " AS maxId FROM customerorder");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            newOrderID = rs.getInt("maxId") + 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newOrderID;
    }


    public String makeOrder(int customerID, int orderID, int shoeID) {
        String errorMsg = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            CallableStatement stmt = con.prepareCall("CALL AddToCart(?,?,?)");
            stmt.setInt(1, customerID);
            stmt.setInt(2, orderID);
            stmt.setInt(3, shoeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                errorMsg = rs.getString("error");
                System.out.println(errorMsg + "sdfghn");
            }
            if (errorMsg.isBlank()) {
                return errorMsg;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Order successful";
    }
}
