package Repository;

import Models.InStock;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class InStockRepository {

    Properties p = new Properties();

    public InStockRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InStock getStockByShoeId (int shoe_ID) {
        InStock inStock = new InStock();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT instock.instock_ID, instock.stock FROM instock" +
                    " INNER JOIN shoe ON shoe.shoe_ID = instock.shoe_ID WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, shoe_ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                inStock = new InStock(rs.getInt("instock_ID"), rs.getInt("stock"));
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return inStock;
    }
}
