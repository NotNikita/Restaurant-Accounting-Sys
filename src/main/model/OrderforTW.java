package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderforTW {
    private SimpleIntegerProperty order_id;
    private SimpleStringProperty order_cold;
    private SimpleStringProperty order_hot;
    private SimpleStringProperty order_drink;
    private SimpleStringProperty order_time;
    private SimpleDoubleProperty order_price;

    public OrderforTW(){}

    public OrderforTW(int id, String cold, String hot, String drink, String time, double price){
        this.order_id =   new SimpleIntegerProperty(id);
        this.order_cold = new SimpleStringProperty(cold);
        this.order_hot =  new SimpleStringProperty(hot);
        this.order_drink =new SimpleStringProperty(drink);
        this.order_time = new SimpleStringProperty(time);
        this.order_price =new SimpleDoubleProperty(price);
    }

    public int getOrder_id() {
        return order_id.get();
    }

    public SimpleIntegerProperty order_idProperty() {
        return order_id;
    }

    public void setOrder_id(int id) {
        this.order_id = new SimpleIntegerProperty(id);
    }

    public String getOrder_cold() {
        return order_cold.get();
    }

    public SimpleStringProperty order_coldProperty() {
        return order_cold;
    }

    public void setOrder_cold(String order_cold) {
        this.order_cold = new SimpleStringProperty(order_cold);
    }

    public String getOrder_hot() {
        return order_hot.get();
    }

    public SimpleStringProperty order_hotProperty() {
        return order_hot;
    }

    public void setOrder_hot(String order_hot) {
        this.order_hot = new SimpleStringProperty(order_hot);
    }

    public String getOrder_drink() {
        return order_drink.get();
    }

    public SimpleStringProperty order_drinkProperty() {
        return order_drink;
    }

    public void setOrder_drink(String order_drink) {
        this.order_drink = new SimpleStringProperty(order_drink);
    }

    public String getOrder_time() {
        return order_time.get();
    }

    public SimpleStringProperty order_timeProperty() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = new SimpleStringProperty(order_time);
    }

    public double getOrder_price() {
        return order_price.get();
    }

    public SimpleDoubleProperty order_priceProperty() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = new SimpleDoubleProperty(order_price);
    }
}
