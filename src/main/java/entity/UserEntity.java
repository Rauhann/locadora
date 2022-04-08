package main.java.entity;

import java.util.List;

public class UserEntity {
    private int code;
    private String name;
    private String login;
    private String password;
    private boolean status;
    private List<ExpenseEntity> expenses;
    private List<ReservationEntity> reservations;
    private List<LocationEntity> locations;

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public List<LocationEntity> getLocations() {
        return locations;
    }

    public List<ExpenseEntity> getExpenses() {
        return expenses;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
