package com.niranjan.Meatme.entities;

import javax.persistence.Entity;

@Entity
public class MenuItem extends Base {

    String menuitemname;
    int description;
    int price;

    public String getMenuitemname() {
        return menuitemname;
    }

    public void setMenuitemname(String menuitemname) {
        this.menuitemname = menuitemname;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
