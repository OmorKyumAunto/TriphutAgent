package com.example.triphutagent;

public class Carmodel {
    String carmodel,liesence,name,number,rent,pimage;
    public Carmodel(){

    }
    public Carmodel(String carmodel, String liesence, String name, String number, String rent, String pimage) {
        this.carmodel = carmodel;
        this.liesence = liesence;
        this.name = name;
        this.number = number;
        this.rent = rent;
        this.pimage = pimage;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getLiesence() {
        return liesence;
    }

    public void setLiesence(String liesence) {
        this.liesence = liesence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }




}
