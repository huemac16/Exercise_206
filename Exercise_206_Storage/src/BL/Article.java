package BL;

import java.io.Serializable;

public class Article implements Serializable {

    private String ID;
    private String description;
    private int place;

    private int amount;

    public Article(String ID, String description, int place) {
        this.ID = ID;
        this.description = description;
        this.place = place;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void buy() throws Exception {
        if (!(amount > 75)) {
            this.amount++;
        } else {
            throw new Exception("Anzahl darf nicht über 75 sein");
        }

    }

    public void sell() throws Exception {

        if (this.amount > 0) {
            this.amount--;
        } else {
            throw new Exception("Anzahl darf nicht kleiner als 0 sein");

        }

    }

}
