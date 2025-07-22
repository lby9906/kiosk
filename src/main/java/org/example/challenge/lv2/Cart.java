package org.example.challenge.lv2;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void printOrders(List<Cart> carts) {
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
        System.out.println("1. 주문      2. 메뉴판      3. 장바구니 메뉴 빼기");
    }

    public void clearCart() {
        menuItems.clear();
        quantity = 0;
        totalPrice = 0;
    }

    public void removeMenuList(List<Cart> carts, String name) {
        setMenuItems(carts.stream()
                .flatMap(menu -> menu.getMenuItems().stream())
                .filter(item -> !item.getName().equals(name))
                .collect(Collectors.toList()));

        setTotalPrice(carts.stream()
                .flatMap(sum -> sum.getMenuItems().stream())
                .mapToInt(MenuItem::getPrice)
                .sum());
    }
}
