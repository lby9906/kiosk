package org.example.essential.lv5;

import java.util.List;

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
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i=0; i< menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i).getName() + "    | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getDescription());
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }
}
