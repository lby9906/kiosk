package org.example.challenge.lv2;

public class DiscountRate {

    public void printDiscountRate() {
        System.out.println("할인 정보를 입력해주세요.");

        String printDiscount = """
                1. 국가유공자 : 10%
                2. 군인     :  5%
                3. 학생     :  3%
                4. 일반     :  0%
                """;
        System.out.println(printDiscount);
    }

    public double discount(DiscountRateType discountRateType, double totalPrice) {
        switch (discountRateType) {
            case STUDENT, MILITARY, NATIONL_MERIT, ORDINARY-> {
                totalPrice = totalPrice - (totalPrice * discountRateType.getRate());
            }
            default -> throw new IllegalArgumentException("유효하지 않은 타입 입니다.");
        }
        return totalPrice;
    }
}
