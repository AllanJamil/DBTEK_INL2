package Repository;

import Models.Brand;
import Models.Color;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ColorRepository {

    private Properties p = new Properties();

    public ColorRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Color getColorByShoeId(int shoe_ID) {
        Color color = new Color();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT Color.color_ID, Color.color_Name FROM color" +
                    " INNER JOIN shoe ON shoe.color_ID = color.color_ID WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, shoe_ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                color = new Color(rs.getInt("color_ID"), rs.getString("color_Name"));
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return color;
    }
}
