package org.example.challenge.lv1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private Cart cart = new Cart();
    private List<Menu> menus = new ArrayList<>();
    private Orders orders = new Orders();

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                if (!cart.getMenuItems().isEmpty()) {
                    Menu.getMenuCategory(menus);
                    Orders.printOrderMenu();
                } else {
                    Menu.getMenuCategory(menus);
                }

                System.out.print("카테고리 번호를 입력하세요: ");
                int categorySelect = in.nextInt();

                if (categorySelect == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;

                } else if (categorySelect == 4) {
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    cart.printOrders(cart);
                    System.out.print("주문 번호 입력: ");
                    int orderSelect = in.nextInt();

                    if (orderSelect == 1) {
                        orders.printOrderSuccess(cart);
                        cart.clearCart();
                        return;
                    } else if (orderSelect == 2) {
                        System.out.println("주문을 취소하고 다시 메뉴를 선택합니다.");
                        continue;

                    } else if (orderSelect < 1 || orderSelect > 2) {
                        throw new IllegalArgumentException("유효하지 않은 주문 번호입니다.");
                    }

                } else if (categorySelect >= 1 && categorySelect <= menus.size()) {
                    printMenuList(menus, categorySelect);

                } else if (categorySelect == 5) {
                    cart.clearCart();
                    System.out.println("다시 메뉴로 돌아갑니다.");
                    continue;

                } else if (categorySelect < 0 || categorySelect > 6) {
                    throw new IllegalArgumentException("유효하지 않은 번호입니다.");
                }


                while (true) {
                    System.out.print("메뉴 번호를 입력하세요: ");
                    int itemSelect = in.nextInt();

                    if (itemSelect == 0) {
                        break;
                    } else if (itemSelect < 0 || itemSelect > 4) {
                        throw new IllegalArgumentException("유효하지 않은 메뉴 번호입니다.");
                    }


                    System.out.print("선택한 메뉴: ");
                    printSelectMenu(categorySelect, itemSelect, menus);

                    System.out.println();
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    System.out.print("장바구니 번호 입력: ");
                    int cartSelect = in.nextInt();

                    MenuItem menuItem = menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1);

                    if (cartSelect == 1) {
                        cart.add(cartSelect, menuItem);
                        break;
                    } else {
                        System.out.println("추가가 취소되었습니다.");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
        }
    }

    private void printMenuList(List<Menu> menus, int categorySelect) {
        Menu selectMenu = menus.get(categorySelect - 1);
        selectMenu.printMenuItems();
        System.out.println("0. 뒤로가기");
        System.out.println();
    }

    private void printSelectMenu(int categorySelect, int itemSelect, List<Menu> menus) {
        System.out.println(
                menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1).getName() + " | W " +
                        menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1).getPrice() + " | " +
                        menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1).getDescription()
        );
    }
}
