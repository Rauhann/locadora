package main.java.entity;

public class GenreEntity {
    private int code;
    private String name;

    public GenreEntity(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public GenreEntity() {
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
