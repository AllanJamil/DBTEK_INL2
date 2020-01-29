package Repository;

import Models.Price;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class PriceRepository {

    Properties p = new Properties();

    public PriceRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Price getPriceByShoeId (int shoe_ID) {
        Price price = new Price();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT price.price_ID, price.price FROM price" +
                    " INNER JOIN shoe ON shoe.price_ID = price.price_ID WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, shoe_ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                price = new Price(rs.getInt("price_ID"), rs.getInt("price"));
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
}
