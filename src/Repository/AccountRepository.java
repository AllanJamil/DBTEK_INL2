package Repository;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class AccountRepository {

    private Properties p = new Properties();

    public AccountRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int logIn(String username, String password) {

        int customer_ID = 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))){
            PreparedStatement stmt = con.prepareStatement("SELECT logInFunction(?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            customer_ID = rs.getObject(1, Integer.class);

        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return -2;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return customer_ID;
    }


}
