package org.example.lv3;

import org.example.lv2.MenuItem;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        int count = 1;
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(count + ". " + menu.getName() + "    | W " + menu.getPrice() + " | " + menu.getDescription());
            count++;
        }

        System.out.println();
        System.out.print("번호를 입력하세요(0 선택 시 프로그램 종료): ");
        int num = in.nextInt();

        while(true) {
            switch (num) {
                case 1: System.out.println("선택한 메뉴 : ShackBurger, 6900, 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2: System.out.println("선택한 메뉴 : SmokeShack, 6900, 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3: System.out.println("선택한 메뉴 : Cheeseburger, 6900, 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4: System.out.println("선택한 메뉴 : Hamburger, 5400, 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                case 0: System.out.println("프로그램을 종료합니다.");
                    break;
                default: throw new IllegalArgumentException("유효하지 않는 입력입니다.");
            }
            break;
        }
    }
}
