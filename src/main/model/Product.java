package main.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private double weight;

    public Product(){}

    public Product(String name, double price, double weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{id: "+id
                + ", name: " + name
                + ", price: " + price
                + ", weight: " + weight +" }";
    }
}
