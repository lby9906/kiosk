package org.example.challenge.lv1;

public class Orders {
    public Orders() {
    }

    public void printOrderSuccess(Cart cart) {
        System.out.println("주문이 완료되었습니다. 금액은 W " + cart.getTotalPrice() + " 입니다.");
    }

    public static void printOrderMenu() {
        System.out.println("[ ORDER MENU ]\n" +
                "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                "5. Cancel       | 진행중인 주문을 취소합니다.");
    }
}
