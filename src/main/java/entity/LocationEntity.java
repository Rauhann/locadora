package main.java.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationEntity {
    private int code;
    private Date date;
    private UserEntity user;
    private ClientEntity client;
    private final List<LocationItemsEntity> locationItems = new ArrayList<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<LocationItemsEntity> getLocationItems() {
        return locationItems;
    }
}
