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

    public void addMenuItem(MenuItem menuItem, int quantity) {
        for (int i=0; i<quantity; i++) {
            menuItems.add(menuItem);
        }
        this.quantity += quantity;
        this.totalPrice += quantity * menuItem.getPrice();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void printOrders(Cart cart) {
        System.out.println("[ Orders ]");
        cart.getMenuItems().stream()
                .forEach(menu -> System.out.println(menu.getName() + " | " + "W " + menu.getPrice() + " | " +
                        menu.getDescription()));
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + cart.getTotalPrice());

        System.out.println();
        System.out.println("1. 주문      2. 메뉴판      3. 메뉴 삭제");
    }

    public void clearCart() {
        menuItems.clear();
        quantity = 0;
        totalPrice = 0;
    }

    public boolean add(int cartSelect, MenuItem menuItem){
        if (cartSelect == 1) {
            addMenuItem(menuItem, 1);
            System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
            return true;
        } else if (cartSelect == 2) {
            return false;
        } else {
            System.out.println("유효하지 않은 장바구니 번호입니다.");
        }
        return true;
    }

    public void removeMenuList(Cart cart, String name) {
        setMenuItems(cart.getMenuItems().stream().filter(item -> !item.getName().equals(name))
                .collect(Collectors.toList()));

        setTotalPrice(cart.getTotalPrice());
    }
}
