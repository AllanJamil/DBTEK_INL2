package Repository;

import Models.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShoeRepository {

    Properties p = new Properties();

    public ShoeRepository() {
        try {
            p.load(new FileInputStream("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\" +
                    "Inlämningsuppgift 2\\INL2\\src\\Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Shoe getShoeById(int ID) {

        Shoe shoe = new Shoe();
        Color color = new ColorRepository().getColorByShoeId(ID);
        Brand brand = new BrandRepository().getBrandByShoeId(ID);
        ShoeSize shoeSize = new ShoeSizeRepository().getShoeSizeByShoeId(ID);
        Price price = new PriceRepository().getPriceByShoeId(ID);
        InStock inStock = new InStockRepository().getStockByShoeId(ID);



        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT shoe.shoe_ID, shoe.shoe_Name FROM shoe" +
                    " WHERE shoe.shoe_ID = ?");
            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                shoe = new Shoe(rs.getInt("shoe_ID"), rs.getString("shoe_Name"), color, shoeSize, brand,
                        price, inStock);
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return shoe;
    }

    // HASHMAP
    public List<Shoe> getAllShoes() {
        List<Shoe> shoes = new ArrayList<>();
        HashMap<Integer, Shoe> map = new HashMap();
        List<Integer> allShoeIds = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement("SELECT shoe.shoe_ID FROM shoe");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                allShoeIds.add(rs.getInt("shoe_ID"));
            }

            allShoeIds.forEach(id -> map.put(id, getShoeById(id)));
            System.out.println("utskrift från map");
            map.forEach((id, item) -> System.out.println(item.getName()));

            shoes = allShoeIds.stream().map(id -> getShoeById(id)).collect(Collectors.toList());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return shoes;
    }
}
