package Repository;

import Models.Brand;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class BrandRepository {

    private Properties p = new Properties();

    public BrandRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Brand getBrandByShoeId(int shoe_ID) {
        Brand brand = new Brand();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT brand.brand_ID, brand.brand_Name FROM brand" +
                    " INNER JOIN shoe ON shoe.brand_ID = brand.brand_ID WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, shoe_ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                brand = new Brand(rs.getInt("brand_ID"), rs.getString("brand_Name"));
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  brand;
    }
}
