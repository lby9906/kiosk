package org.example.lv5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int categorySelect;

        while (true) {
            try {
                Menu.getMenuCategory(menus);
                System.out.print("카테고리 번호를 입력하세요: ");
                categorySelect = in.nextInt();

                if (categorySelect == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                Menu selectMenu = menus.get(categorySelect - 1);
                selectMenu.printMenuItems();
                System.out.println("0. 뒤로가기");
                System.out.println();

            }catch (InputMismatchException e) {
                throw new IllegalArgumentException("주어진 번호만 입력하실 수 있습니다.");
            }

            try {
                while (true) {
                    System.out.print("메뉴 번호를 입력하세요: ");
                    int itemSelect = in.nextInt();

                    if (itemSelect == 0) {
                        break;
                    }
                    printSelectMenu(categorySelect, itemSelect, menus);
                }
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("주어진 번호만 입력하실 수 있습니다.");
            }
        }
    }

    public void printSelectMenu(int categorySelect, int itemSelect, List<Menu> menus) {
        System.out.println("선택한 메뉴: " +
                menus.get(categorySelect-1).getMenuItems().get(itemSelect - 1).getName() + " | W " +
                menus.get(categorySelect-1).getMenuItems().get(itemSelect - 1).getPrice() + " | " +
                menus.get(categorySelect-1).getMenuItems().get(itemSelect - 1).getDescription()
        );
    }
}
