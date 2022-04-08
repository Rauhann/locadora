package main.java.entity;

public class CategoryEntity {
    private int code;
    private String name;
    private double value;
    private int period;
    private boolean indicatePromotion;
    private int periodPromotion;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public boolean isIndicatePromotion() {
        return indicatePromotion;
    }

    public void setIndicatePromotion(boolean indicatePromotion) {
        this.indicatePromotion = indicatePromotion;
    }

    public int getPeriodPromotion() {
        return periodPromotion;
    }

    public void setPeriodPromotion(int periodPromotion) {
        this.periodPromotion = periodPromotion;
    }
}
