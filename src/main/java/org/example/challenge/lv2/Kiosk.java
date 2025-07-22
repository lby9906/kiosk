package org.example.challenge.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private Cart cart = new Cart();
    private List<Menu> menus = new ArrayList<>();
    private Orders orders = new Orders();
    private DiscountRate discountRate = new DiscountRate();

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int categorySelect;
        int itemSelect;

        while (true) {
            try {
                Menu.getMenuCategory(menus);
                System.out.print("카테고리 번호를 입력하세요: ");
                categorySelect = in.nextInt();

                if (categorySelect == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (categorySelect < 0 || categorySelect > 3) {
                    throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
                }

                printMenuList(menus, categorySelect);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }

            while (true) {
                try {
                    System.out.print("메뉴 번호를 입력하세요: ");
                    itemSelect = in.nextInt();

                    if (itemSelect == 0) {
                        break;
                    } else if (itemSelect < 0 || itemSelect > 4) {
                        throw new IllegalArgumentException("유효하지 않은 메뉴 번호입니다.");
                    }

                    System.out.print("선택한 메뉴: ");
                    printSelectMenu(categorySelect, itemSelect, menus);

                    try {
                        System.out.println();
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        System.out.print("장바구니 번호 입력: ");
                        int cartSelect = in.nextInt();

                        if (cartSelect == 1) {
                            cart.addMenuItem(menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1),
                                    1,
                                    menus.get(categorySelect - 1).getMenuItems().get(itemSelect - 1).getPrice());

                            System.out.println(
                                    cart.getMenuItems().get(cart.getMenuItems().size() - 1).getName()
                                            + " 이 장바구니에 추가되었습니다.");
                        } else if (cartSelect == 2) {
                            break;
                        } else if (cartSelect > 2) {
                            throw new IllegalArgumentException("유효하지 않은 장바구니 번호입니다.");
                        }

                        try {
                            if (cart.getQuantity() > 0) {
                                Menu.getMenuCategory(menus);
                                orders.printOrderMenu();
                                System.out.print("번호 입력: ");
                                int orderSelect = in.nextInt();

                                if (orderSelect == 4) {
                                    System.out.println("아래와 같이 주문 하시겠습니까?");
                                    cart.printOrders(List.of(cart));
                                    System.out.print("주문 번호 입력: ");
                                    int finalSelect = in.nextInt();

                                    System.out.println();

                                    if (finalSelect == 1) {
                                        discountRate.printDiscountRate();
                                        System.out.print("할인 정보 입력: ");
                                        int discountSelect = in.nextInt();
                                        applyDiscountOrder(discountSelect);
                                        break;
                                    } else if (finalSelect == 2) {
                                        System.out.println("주문을 취소하고 다시 메뉴를 선택합니다.");
                                        break;
                                    } else if (finalSelect == 3) {
                                        System.out.print("삭제할 메뉴 이름을 입력: ");
                                        String remove = in.next();
                                        cart.removeMenuList(List.of(cart), remove);
                                        cart.printOrders(List.of(cart));
                                        break;

                                    } else if (finalSelect < 1 || finalSelect > 3) {
                                        throw new IllegalArgumentException("유효하지 않은 주문 번호입니다.");
                                    }
                                } else if (orderSelect >= 1 && orderSelect <= menus.size()) {
                                    categorySelect = orderSelect;
                                    printMenuList(menus, categorySelect);
                                } else if (orderSelect == 5) {
                                    cart.clearCart();
                                    System.out.println("주문을 취소하고 다시 메뉴를 선택합니다.");
                                    break;
                                } else if (orderSelect < 0 || orderSelect > 5) {
                                    throw new IllegalArgumentException("유효하지 않은 번호입니다.");
                                }
                            }

                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
                        }
                    } catch (InputMismatchException e) {
                        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
                    }
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("유효하지 않은 입력입니다.");
                }
            }
        }
    }

    private void applyDiscountOrder(int discountSelect) {
        double discountPrice = cart.getTotalPrice();

        switch (discountSelect) {
            case 1 -> discountPrice = discountRate.discountNationlMerit(DiscountRateType.NATIONL_MERIT, cart.getTotalPrice());
            case 2 -> discountPrice = discountRate.discountMilitary(DiscountRateType.MILITARY, cart.getTotalPrice());
            case 3 -> discountPrice = discountRate.discountStudent(DiscountRateType.STUDENT, cart.getTotalPrice());
            case 4 -> discountPrice = discountRate.discountOrdinary(DiscountRateType.ORDINARY, cart.getTotalPrice());
        }
        orders.setOrders(cart, discountPrice);
        cart.clearCart();
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
