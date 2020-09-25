package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductForTW {
    private SimpleIntegerProperty Product_id;
    private SimpleStringProperty Product_name;
    private SimpleDoubleProperty Product_price;
    private SimpleDoubleProperty Product_weight;

    public ProductForTW(){}

    public ProductForTW(int id ,String name, double price, double weight){
        this.Product_id = new SimpleIntegerProperty(id);
        this.Product_name = new SimpleStringProperty(name);
        this.Product_price = new SimpleDoubleProperty(price);
        this.Product_weight = new SimpleDoubleProperty(weight);
    }

    public int getProduct_id() {
        return Product_id.get();
    }

    public SimpleIntegerProperty product_idProperty() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        this.Product_id.set(product_id);
    }

    public String getProduct_name() {
        return Product_name.get();
    }

    public SimpleStringProperty product_nameProperty() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        this.Product_name.set(product_name);
    }

    public double getProduct_price() {
        return Product_price.get();
    }

    public SimpleDoubleProperty product_priceProperty() {
        return Product_price;
    }

    public void setProduct_price(double product_price) {
        this.Product_price.set(product_price);
    }

    public double getProduct_weight() {
        return Product_weight.get();
    }

    public SimpleDoubleProperty product_weightProperty() {
        return Product_weight;
    }

    public void setProduct_weight(double product_weight) {
        this.Product_weight.set(product_weight);
    }
}
