package main.model;

import main.sample.DatabaseHandler;

import java.sql.SQLException;

public class Meal {
    private String name;
    private String product1;
    private String product2;

    private double weight1;
    private double weight2;

    private double price = 0.0;

    public Meal(String food_name,String prod1, String prod2, double wg1, double wg2){
        this.name = food_name;
        this.product1 = prod1;
        this.product2 = prod2;

        this.weight1 = wg1;
        this.weight2 = wg2;
    }

    public Meal(String food_name,String prod1, String prod2){
        this.name = food_name;
        this.product1 = prod1;
        this.product2 = prod2;
    }

    public double getPrice() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        price += dbHandler.getPriceOfProduct(product1);
        price += dbHandler.getPriceOfProduct(product2);
        System.out.println(name + " will cost " + price);

        return price;
    }

    public String getName(){
        return this.name;
    };

    public String getProduct1(){
        return product1;
    }

    public String getProduct2() {
        return product2;
    }

    public double getWeight1() {
        return weight1;
    }

    public double getWeight2() {
        return weight2;
    }
}
