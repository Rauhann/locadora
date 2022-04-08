package main.java.entity;

import java.util.Date;

public class LocationItemsEntity {
    private Date devolutionDate;
    private TitleEntity title;

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public TitleEntity getTitle() {
        return title;
    }

    public void setTitle(TitleEntity title) {
        this.title = title;
    }
}
