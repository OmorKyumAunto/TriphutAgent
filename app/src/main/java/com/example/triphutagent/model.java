package com.example.triphutagent;

public class model {

    String Cost, Details, Duration, Hotel, Place,timage;
    public model() {
    }

    public model(String cost, String details, String duration, String hotel, String place, String timage) {

        this.Cost = cost;
        this.Details = details;
        this.Duration = duration;
        this.Hotel = hotel;
        this.Place = place;
        this.timage = timage;

    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String gettimage() {
        return timage;
    }

    public void setPimage(String timage) {
        this.timage = timage;
    }
}
