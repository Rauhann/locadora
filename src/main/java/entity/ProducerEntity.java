package main.java.entity;

public class ProducerEntity {
    private int code;
    private String name;

    public ProducerEntity(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public ProducerEntity() {
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
}
