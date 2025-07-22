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
        int count = 1;
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(count + ". " + menu.getName() + "    | W " + menu.getPrice() + " | " + menu.getDescription());
            count++;
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }
}
