package main.sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.Order;
import main.model.OrderforTW;
import main.model.Product;
import main.model.Dish;
import main.sample.Configs;
import main.sample.Const;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbconnection;

    public Connection getDbconnection()
            throws ClassNotFoundException, SQLException
    {

        String  connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbconnection = DriverManager.getConnection(connectionString, dbUser,
                dbPass);

        if (dbconnection != null) { System.out.println("Successfully connected to MySQL database test"); }

        return dbconnection;
    }

    //write methods
    public void addNewOrder(Order order){
        //sql request
        String insert = "INSERT INTO " + Const.ORDERS_TABLE + "(" + Const.ORDER_MEAL1 + "," + Const.ORDER_MEAL2
                + "," + Const.ORDER_MEAL3 + "," + Const.ORDER_DATE + "," +Const.ORDER_PRICE + ")" + "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(insert);
            prSt.setString(1, order.meal1.getName());
            prSt.setString(2, order.meal2.getName());
            prSt.setString(3, order.drink.getName());
            prSt.setString(4, order.getDate());
            prSt.setString(5, String.valueOf(order.getPrice()));

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addNewProduct(Product product){
        //sql request
        String insert = "INSERT INTO " + Const.PRODUCTS_TABLE + "(" + Const.PRODUCT_NAME + "," + Const.PRODUCT_PRICE
                + "," + Const.PRODUCT_WEIGHTLEFT + ")" + "VALUES(?,?,?)";


        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(insert);
            prSt.setString(1, product.getName());
            prSt.setString(2, String.valueOf(product.getPrice()));
            prSt.setString(3, String.valueOf(product.getWeight()));

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //read methods

    public ObservableList<Product> getStockProducts(){
        ObservableList<Product> ListToReturn = FXCollections.observableArrayList();
        String select = "SELECT * FROM "  + Const.PRODUCTS_TABLE;

        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery(select);

            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setWeight(resultSet.getDouble(4));

                System.out.println(product);
                ListToReturn.add(product);
            }


            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            prSt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ListToReturn;
    }

    public ObservableList<Dish> getMenuProducts() {
        ObservableList<Dish> ListToReturn = FXCollections.observableArrayList();
        String select = "SELECT * FROM "  + Const.DISHES_TABLE;

        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery(select);

            while(resultSet.next()){
                Dish item = new Dish();

                item.setItem_id(resultSet.getInt(1));
                item.setItem_name(resultSet.getString(2));
                item.setItem_prod1(resultSet.getString(3));
                item.setItem_prod2(resultSet.getString(4));

                ListToReturn.add(item);
            }


            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            prSt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ListToReturn;
    }

    public ObservableList<OrderforTW> getLastOrders(){
        ObservableList<OrderforTW> ListToReturn = FXCollections.observableArrayList();
        String select = "SELECT * FROM "  + Const.ORDERS_TABLE;

        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery(select);

            while(resultSet.next()){
                OrderforTW item = new OrderforTW();

                item.setOrder_id(resultSet.getInt(1));
                item.setOrder_cold(resultSet.getString(2));
                item.setOrder_hot(resultSet.getString(3));
                item.setOrder_drink(resultSet.getString(4));
                item.setOrder_time(resultSet.getString(5));
                item.setOrder_price(resultSet.getDouble(6));

                ListToReturn.add(item);
            }


            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            prSt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ListToReturn;
    }

    public double getPriceOfProduct(String product) {
        double resultPriceOfProduct = 0.0;
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "restdb." + Const.PRODUCTS_TABLE + " WHERE " +
                Const.PRODUCT_NAME + "='" + product + "';";
        //String select = "SELECT * FROM restdb.products WHERE name_prod='кефир';";

        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(select);
            //prSt.setString(1, product);
            resSet = prSt.executeQuery(select);

            while(resSet.next()){
                resultPriceOfProduct = resSet.getDouble(3);
                System.out.println("price of" + resSet.getString(2) + " is " + resultPriceOfProduct);
            }

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultPriceOfProduct;
    }
}
