package org.example.challenge.lv1;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> menuItems = new ArrayList<>();
    private int quantity;
    private int totalPrice;

    public Cart() {
    }

    public void addMenuItem(MenuItem menuItem, int quantity, int price) {
        for (int i=0; i<quantity; i++) {
            menuItems.add(menuItem);
        }
        this.quantity += quantity;
        this.totalPrice += quantity*price;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public static void printOrders(List<Cart> carts) {
        System.out.println("[ Orders ]");
        for (Cart cart : carts) {
            cart.getMenuItems().stream()
                    .forEach(menu -> System.out.println(menu.getName() + " | " + "W " + menu.getPrice() + " | " +
                            menu.getDescription()));
        }
        System.out.println();
        System.out.println("[ Total ]");
        for (Cart cartPrice : carts) {
            System.out.println("W " + cartPrice.getTotalPrice());
        }
        System.out.println();
        System.out.println("1. 주문      2. 메뉴판");
    }

    public void clearCart() {
        menuItems.clear();
        quantity = 0;
        totalPrice = 0;
    }
}
