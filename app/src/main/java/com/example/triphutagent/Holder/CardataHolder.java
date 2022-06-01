package com.example.triphutagent.Holder;


public class CardataHolder {


    String name,number,liesence,carmodel,rent,pimage;

    public CardataHolder(String name, String number, String liesence, String carmodel, String rent, String pimage) {
        this.name = name;
        this.number = number;
        this.liesence = liesence;
        this.carmodel = carmodel;
        this.rent = rent;
        this.pimage = pimage;
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

    public String getLiesence() {
        return liesence;
    }

    public void setLiesence(String liesence) {
        this.liesence = liesence;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
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
