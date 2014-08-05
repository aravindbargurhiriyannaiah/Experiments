package com.funkyganesha.visitor;

/**
 * Created by barga009 on 8/2/14 at 10:33 PM. Comment {"$EXPR$"}
 */
public class Book implements Visitable {

    private String name;
    private double weight;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
