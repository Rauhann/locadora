package main.java.entity;

public class CategoryEntity {
    private int code;
    private String name;
    private double value;
    private int period;
    private int indicatePromotion;
    private int periodPromotion;

    public CategoryEntity(int code, String name, double value, int period, int indicatePromotion, int periodPromotion) {
        this.code = code;
        this.name = name;
        this.value = value;
        this.period = period;
        this.indicatePromotion = indicatePromotion;
        this.periodPromotion = periodPromotion;
    }

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

    public int isIndicatePromotion() {
        return indicatePromotion;
    }

    public void setIndicatePromotion(int indicatePromotion) {
        this.indicatePromotion = indicatePromotion;
    }

    public int getPeriodPromotion() {
        return periodPromotion;
    }

    public void setPeriodPromotion(int periodPromotion) {
        this.periodPromotion = periodPromotion;
    }
}
