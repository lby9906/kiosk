package org.example.lv4;


import org.example.lv2.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        Menu menuBurgers = new Menu(List.of(
                new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 6900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")),
                "Burgers");

        Menu menuDrinks = new Menu(List.of(
                new MenuItem("Lemonade", 3900, "직접 만드는 상큼한 레몬에이드"),
                new MenuItem("Fountain Soda", 3300, "시원한 코카콜라"),
                new MenuItem("Iced Tea", 3400, "아이스티"),
                new MenuItem("Bottled Water", 3400, "지리산 암반대수층으로 만든 프리미엄 생수")),
                "Drinks");

        Menu menuDesserts = new Menu(List.of(
                new MenuItem("Shack Attack", 5900, "진한 초콜릿 커스터드에 세가지 초콜릿 토핑이 올라간 콘크리트"),
                new MenuItem("Shack in the garden", 5900, "바닐라 커스터드에 라즈베리 잼이 달콤하게 블랜딩된 콘크리트"),
                new MenuItem("Gangnam", 5900, "달콤한 딸기 잼과 고소한 콩가루가 들어간 콘크리트"),
                new MenuItem("Cheongdam327", 5900, "바나나와 꿀, 쇼트브레드가 어우러진 콘크리트")),
                "Desserts");

        List<Menu> menuList = new ArrayList<>();
        menuList.add(menuBurgers);
        menuList.add(menuDrinks);
        menuList.add(menuDesserts);

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
