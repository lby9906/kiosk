package org.example.challenge.lv1;

public class MenuItem {

    private String name;
    private int price;
    private String description;

    public MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static MenuItem of(String name, int price, String description) {
        return new MenuItem(name, price, description);
    }
}
