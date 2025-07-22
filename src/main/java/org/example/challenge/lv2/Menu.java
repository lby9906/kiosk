package org.example.challenge.lv2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private List<MenuItem> menuItems;
    private String category;

    public void setMenus(List<MenuItem> menuItems, String category) {
        this.menuItems = menuItems;
        this.category = category;
    }
    public static void getMenuCategory(List<Menu> menus) {
        System.out.println("[MAIN MENU]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료      | 종료");
    }

    public void printMenuItems() {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println("[ SHAKESHACK MENU ]");

        menuItems.stream().forEach(menu ->
                System.out.println(count.getAndIncrement() + ". " + menu.getName() + "    | W " + menu.getPrice() + " | " + menu.getDescription()
        ));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }
}
