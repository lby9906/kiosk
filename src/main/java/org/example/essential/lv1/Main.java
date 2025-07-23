package org.example.essential.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String menu = """
       [ SHAKESHACK MENU ]
       1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
       2. SmokeShack    | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
       3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
       4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
       0. 종료           | 종료
        """;
        System.out.println(menu);
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
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("주어진 번호만 입력하실 수 있습니다.");
            }
        }
    }
}