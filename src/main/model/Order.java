package main.model;

import java.sql.SQLException;

public class Order {
    public Meal meal1;
    public Meal meal2;
    public Meal drink;
    private String date;

    public double price = 0.0;

    public double getPrice(){
        return price;
    }

    public String getDate(){ return this.date;}

    public void setDate(String today){ date = today;}

    public void setColdMeal(Meal cold_meal) throws SQLException {
        meal1 = cold_meal;
        price += meal1.getPrice();
    }

    public void setHotMeal(Meal hot_meal) throws SQLException {
        meal2 = hot_meal;
        price += meal2.getPrice();
    }

    public void setDrink(Meal drink_meal) throws SQLException {
        drink = drink_meal;
        price += drink.getPrice();
    }
}
