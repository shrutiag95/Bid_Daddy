package com.biddaddy.pdg.bidding;


import java.util.HashMap;
import java.util.Map;


public class model {
    String itemname;
    String price;
    String id;
    String des;
    String current_max;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCurrent_max() {
        return current_max;
    }

    public void setCurrent_max(String current_max) {
        this.current_max = current_max;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
