package com.example.carlos.sesion9.beans;

/**
 * Created by Carlos on 21/09/2017.
 */

public class ItemProduct {
    private int image;
    private String title;
    private String store;
    private String location;
    private String phone;
    private String description;


    public ItemProduct(){
        image = 0;
        title = store = location = phone = description = "";
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString(){
        return "Image:" + image + " Title:" + title + " Store:" + store + " Location:" + location + " Phone:" + phone + " Description:" + description;
    }
}
