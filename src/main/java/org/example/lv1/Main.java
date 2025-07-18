package org.example.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(
                "[ SHAKESHACK MENU ] \n" +
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거 \n"+
                "2. SmokeShack    | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거 \n" +
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거 \n" +
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거 \n" +
                "0. 종료           | 종료");
        System.out.println();
        System.out.print("번호를 입력하세요(0 선택 시 프로그램 종료): ");
        int num = in.nextInt();

        while(true) {
            switch (num) {
                case 1: System.out.println("선택한 메뉴 : ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2: System.out.println("선택한 메뉴 : mokeShack    | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3: System.out.println("선택한 메뉴 : Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4: System.out.println("선택한 메뉴 : Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                case 0: System.out.println("프로그램을 종료합니다.");
                    break;
            }
            break;
        }
    }
}