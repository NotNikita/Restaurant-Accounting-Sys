package main.model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Dish {
    private SimpleIntegerProperty item_id;
    private SimpleStringProperty item_name;
    private SimpleStringProperty item_prod1;
    private SimpleStringProperty item_prod2;

    public Dish(){}

    public Dish(int id, String name, String prod1, String prod2){
        this.item_id = new SimpleIntegerProperty(id);
        this.item_name = new SimpleStringProperty(name);
        this.item_prod1 = new SimpleStringProperty(prod1);
        this.item_prod2 = new SimpleStringProperty(prod2);
    }


    public int getItem_id() {
        return item_id.get();
    }

    public SimpleIntegerProperty item_idProperty() {
        return item_id;
    }

    public void setItem_id(int id) {
        this.item_id = new SimpleIntegerProperty(id);
    }

    public String getItem_name() {
        return item_name.get();
    }

    public SimpleStringProperty item_nameProperty() {
        return item_name;
    }

    public void setItem_name(String name) {
        this.item_name = new SimpleStringProperty(name);
    }

    public String getItem_prod1() {
        return item_prod1.get();
    }

    public SimpleStringProperty item_prod1Property() {
        return item_prod1;
    }

    public void setItem_prod1(String prod1) {
        this.item_prod1 = new SimpleStringProperty(prod1);
    }

    public String getItem_prod2() {
        return item_prod2.get();
    }

    public SimpleStringProperty item_prod2Property() {
        return item_prod2;
    }

    public void setItem_prod2(String prod2) {
        this.item_prod2 = new SimpleStringProperty(prod2);
    }
}
