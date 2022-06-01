package com.example.triphutagent.Holder;

public class TourdataHolder {
    String id,place,duration,hotel,brif,cost,Timage;

    public TourdataHolder(String id,String place, String duration, String hotel, String brif, String cost, String Timage) {
        this.id=id;
        this.place = place;

        this.duration = duration;
        this.hotel = hotel;
        this.brif = brif;
        this.cost = cost;
        this.Timage = Timage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getBrif() {
        return brif;
    }

    public void setBrif(String brif) {
        this.brif = brif;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTimage() {
        return Timage;
    }

    public void setTimage(String pimage) {
        this.Timage = Timage;
    }
}
