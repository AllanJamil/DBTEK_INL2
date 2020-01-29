package Repository;

import Models.ShoeSize;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ShoeSizeRepository {

    private Properties p = new Properties();

    public ShoeSizeRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShoeSize getShoeSizeByShoeId (int shoe_ID) {
        ShoeSize shoeSize = new ShoeSize();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT shoeSize.shoeSize_ID, shoeSize.shoeSize FROM shoesize" +
                    " INNER JOIN shoe ON shoe.shoeSize_ID = shoesize.shoeSize_ID WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, shoe_ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                shoeSize = new ShoeSize(rs.getInt("shoeSize_ID"), rs.getInt("shoeSize"));
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return shoeSize;
    }
}
