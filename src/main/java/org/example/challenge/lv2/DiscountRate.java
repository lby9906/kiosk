package org.example.challenge.lv2;

public class DiscountRate {

    public void printDiscountRate() {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println(
                 "1. 국가유공자 : 10% \n" +
                 "2. 군인     :  5% \n" +
                 "3. 학생     :  3% \n" +
                 "4. 일반     :  0%");
    }

    public double discountStudent(DiscountRateType discountRateType, double totalPrice) {
        if (discountRateType == DiscountRateType.STUDENT) {
            double discount = totalPrice * 0.03;
            totalPrice = totalPrice - discount;
        }
        return totalPrice;
    }

    public double discountMilitary(DiscountRateType discountRateType, double totalPrice) {
        if (discountRateType == DiscountRateType.MILITARY) {
            double discount = totalPrice * 0.05;
            totalPrice = totalPrice - discount;
        }
        return totalPrice;
    }

    public double discountNationlMerit(DiscountRateType discountRateType, double totalPrice) {
        if (discountRateType == DiscountRateType.NATIONL_MERIT) {
            double discount = totalPrice * 0.1;
            totalPrice = totalPrice - discount;
        }
        return totalPrice;
    }

    public double discountOrdinary(DiscountRateType discountRateType, double totalPrice) {
        if (discountRateType == DiscountRateType.ORDINARY) {
            totalPrice = totalPrice - 0;
        }
        return totalPrice;
    }
}
