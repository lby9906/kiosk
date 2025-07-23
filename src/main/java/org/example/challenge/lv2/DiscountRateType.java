package org.example.challenge.lv2;

public enum DiscountRateType {
    STUDENT(0.03), ORDINARY(0), MILITARY(0.05), NATIONL_MERIT(0.1);

    private final double rate;

    DiscountRateType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
