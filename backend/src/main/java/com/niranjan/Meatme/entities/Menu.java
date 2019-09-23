package com.niranjan.Meatme.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Menu extends Base {

    String menuname;

    public List<MenuItem> getMenuitemlist() {
        return menuitemlist;
    }

    public void setMenuitemlist(List<MenuItem> menuitemlist) {
        this.menuitemlist = menuitemlist;
    }

    @OneToMany
    List<MenuItem> menuitemlist = new LinkedList<>();

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }





}
