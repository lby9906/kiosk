package org.example.essential.lv3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        for (int i=0; i< menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i).getName() + "    | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getDescription());
        }
        System.out.println("0. 종료           | 종료");
        System.out.println();

        while (true) {
            System.out.print("메뉴 번호를 입력하세요: ");
            try {
                int menuSelect = in.nextInt();

                if (menuSelect == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (menuSelect < 0 || menuSelect > 4) {
                    System.out.println("주어진 번호만 입력해주세요.");
                    continue;
                }
                switch (menuSelect) {
                    case 1 -> System.out.println("선택한 메뉴 : ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    case 2 -> System.out.println("선택한 메뉴 : SmokeShack    | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    case 3 -> System.out.println("선택한 메뉴 : Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    case 4 -> System.out.println("선택한 메뉴 : Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                }
            }catch (InputMismatchException e) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }
        }
    }
}
