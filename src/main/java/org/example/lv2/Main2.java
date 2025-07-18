package org.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 6900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner in = new Scanner(System.in);

        int count = 1;
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(count + ". " + menu.getName() + "    | W " + menu.getPrice() + " | " + menu.getDescription());
            count++;
        }

        System.out.println();
        System.out.print("번호를 입력하세요: ");
        int num = in.nextInt();

        while(true) {
            switch (num) {
                case 1: System.out.println("선택한 메뉴: ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2: System.out.println("선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3: System.out.println("선택한 메뉴: Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4: System.out.println("선택한 메뉴: Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                case 0: System.out.println("프로그램을 종료합니다.");
                    break;
            }
            break;
        }
    }
}
