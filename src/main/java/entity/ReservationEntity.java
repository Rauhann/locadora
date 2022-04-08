package main.java.entity;

import java.util.Date;
import java.util.List;

public class ReservationEntity {
    private int code;
    private Date date;
    private UserEntity user;
    private List<TitleEntity> title;
    private List<ClientEntity> client;

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

    public List<TitleEntity> getTitle() {
        return title;
    }

    public List<ClientEntity> getClient() {
        return client;
    }
}
